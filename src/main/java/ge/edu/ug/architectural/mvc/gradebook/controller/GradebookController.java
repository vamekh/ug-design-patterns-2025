package ge.edu.ug.architectural.mvc.gradebook.controller;

import ge.edu.ug.architectural.mvc.gradebook.model.Gradebook;
import ge.edu.ug.architectural.mvc.gradebook.view.GradebookView;

// Controller: turns one command line into calls on the model and the view.
public class GradebookController {
    private final Gradebook model;
    private final GradebookView view;

    public GradebookController(Gradebook model, GradebookView view) {
        this.model = model;
        this.view = view;
    }

    // Returns false when the user asked to quit.
    public boolean handle(String line) {
        String[] parts = line.trim().split("\\s+");
        switch (parts[0]) {
            case "add" -> {
                if (parts.length != 3) {
                    view.showMessage("Usage: add <name> <grade>");
                    return true;
                }
                try {
                    model.addGrade(parts[1], Integer.parseInt(parts[2]));
                } catch (NumberFormatException e) {
                    view.showMessage("Grade must be a number");
                } catch (IllegalArgumentException e) {
                    view.showMessage(e.getMessage());
                }
            }
            case "list" -> view.showStudents(model.getStudents());
            case "average" -> view.showAverage(model.getAverage());
            case "quit" -> {
                view.showMessage("Bye");
                return false;
            }
            default -> view.showMessage("Unknown command: " + parts[0]);
        }
        return true;
    }
}
