package ge.edu.ug.architectural.mvc.gradebook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// PROBLEM: input parsing, grade storage, business rules and console output all live in one class.
// The only way to test the average is to feed text in and parse System.out back; adding a second
// UI (CSV export, GUI, web) means copying the logic, and any output change can break the "model".
public class GradebookApp {
    private final Scanner scanner;
    private final List<String> names = new ArrayList<>();
    private final List<Integer> grades = new ArrayList<>();

    public GradebookApp(InputStream in) {
        this.scanner = new Scanner(in);
    }

    public void run() {
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            switch (parts[0]) {
                case "add" -> {
                    if (parts.length != 3) {
                        System.out.println("Usage: add <name> <grade>");
                        continue;
                    }
                    int grade;
                    try {
                        grade = Integer.parseInt(parts[2]);
                    } catch (NumberFormatException e) {
                        System.out.println("Grade must be a number");
                        continue;
                    }
                    if (grade < 0 || grade > 100) {
                        System.out.println("Grade must be between 0 and 100");
                        continue;
                    }
                    names.add(parts[1]);
                    grades.add(grade);
                    System.out.println("Added " + parts[1] + ": " + grade);
                }
                case "list" -> {
                    for (int i = 0; i < names.size(); i++) {
                        System.out.println(names.get(i) + ": " + grades.get(i));
                    }
                }
                case "average" -> {
                    double sum = 0;
                    for (int grade : grades) {
                        sum += grade;
                    }
                    double average = grades.isEmpty() ? 0 : sum / grades.size();
                    System.out.printf("Average: %.2f%n", average);
                }
                case "quit" -> {
                    System.out.println("Bye");
                    return;
                }
                default -> System.out.println("Unknown command: " + parts[0]);
            }
        }
    }
}
