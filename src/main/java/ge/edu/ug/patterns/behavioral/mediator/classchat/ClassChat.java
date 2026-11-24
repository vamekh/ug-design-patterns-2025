package ge.edu.ug.patterns.behavioral.mediator.classchat;

import java.io.PrintStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Mediator: users never talk to each other, they only register with and post to the chat.
// A user is identified by the IP address they connect from.
public class ClassChat {
    public static final int MAX_NAME_LENGTH = 30;
    public static final int MAX_MESSAGE_LENGTH = 500;

    private static final DateTimeFormatter TIME = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final Map<String, String> namesByIp = new LinkedHashMap<>();
    private final List<String> history = new ArrayList<>();
    private final List<String> warnings = new ArrayList<>();
    private final PrintStream out;

    public ClassChat() {
        this(System.out);
    }

    public ClassChat(PrintStream out) {
        this.out = out;
    }

    // Registers the IP under a name; registering again from the same IP renames the user
    public synchronized String register(String ip, String name) {
        String cleanName = clean(name, MAX_NAME_LENGTH);
        if (cleanName.isEmpty()) {
            throw new IllegalArgumentException("name is required");
        }
        String oldName = namesByIp.put(ip, cleanName);
        if (oldName == null) {
            print("*** " + cleanName + " joined from " + ip);
        } else if (!oldName.equals(cleanName)) {
            print("*** " + oldName + " is now " + cleanName);
        }
        return cleanName;
    }

    public synchronized void post(String ip, String text) {
        String name = namesByIp.get(ip);
        String cleanText = clean(text, MAX_MESSAGE_LENGTH);
        if (name == null) {
            warn("unknown IP " + ip + " sent a message without registering: \"" + cleanText + "\"");
            throw new IllegalStateException(ip + " is not registered");
        }
        if (cleanText.isEmpty()) {
            throw new IllegalArgumentException("message is empty");
        }
        print(name + ": " + cleanText);
    }

    // Printed on the server console, but not part of the chat history
    public synchronized void warn(String warning) {
        String line = "⚠ WARNING: " + clean(warning, MAX_MESSAGE_LENGTH);
        warnings.add(line);
        out.println("[" + LocalTime.now().format(TIME) + "] " + line);
    }

    public synchronized List<String> getWarnings() {
        return Collections.unmodifiableList(new ArrayList<>(warnings));
    }

    public synchronized Optional<String> nameOf(String ip) {
        return Optional.ofNullable(namesByIp.get(ip));
    }

    public synchronized List<String> getHistory() {
        return Collections.unmodifiableList(new ArrayList<>(history));
    }

    private void print(String line) {
        history.add(line);
        out.println("[" + LocalTime.now().format(TIME) + "] " + line);
    }

    // One line only: no newlines or control characters, so nobody can fake other users' lines
    private static String clean(String text, int maxLength) {
        if (text == null) {
            return "";
        }
        String oneLine = text.replaceAll("\\p{Cntrl}", " ").trim();
        return oneLine.length() > maxLength ? oneLine.substring(0, maxLength) + "…" : oneLine;
    }
}
