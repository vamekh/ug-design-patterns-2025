package ge.edu.ug.architectural.mvc.gradebook;

import ge.edu.ug.architectural.mvc.gradebook.controller.GradebookController;
import ge.edu.ug.architectural.mvc.gradebook.model.Gradebook;
import ge.edu.ug.architectural.mvc.gradebook.view.ConsoleView;

import java.io.InputStream;
import java.util.Scanner;

// Wiring only: create Model, View and Controller, connect them, feed input lines to the controller.
public class GradebookApp {
    private final Scanner scanner;
    private final GradebookController controller;

    public GradebookApp(InputStream in) {
        this.scanner = new Scanner(in);
        Gradebook model = new Gradebook();
        ConsoleView view = new ConsoleView();
        model.addListener(view);
        this.controller = new GradebookController(model, view);
    }

    public void run() {
        while (scanner.hasNextLine()) {
            if (!controller.handle(scanner.nextLine())) {
                return;
            }
        }
    }
}
