package utilities;

// This class handles errors by printing them to the standard error stream
public class ErrorHandler {
    
    // Handles errors by printing them to the console
    public void handle(String error) {
        System.err.println("Error: " + error);
        System.exit(1);
    }

    // Handles exceptions by converting them to strings and passing them to the handle method
    public void handle(Exception e) {
        handle(e.toString());
        System.exit(1);
    }

}
