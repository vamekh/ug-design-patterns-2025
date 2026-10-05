package ge.edu.ug.patterns.structural.decorator.notifier;

public class DatabaseService {
    String getMailFromUsername(String username) {
        return username + "@gmail.com";
    }

    String getFbUsername(String username) {
        return username + "_fb";
    }

    String getInsta(String username) {
        return username + "_insta";
    }
}
