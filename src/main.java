// import objects.Student;
// import objects.outputRow;
// import objects.Course;
// import parsers.studentParser;
// import parsers.courseParser;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.HashMap;
// import java.util.Map;

import java.io.File;
import java.util.Scanner;
import parsers.CourseParser;
import parsers.StudentParser;
import utilities.ErrorHandler;


public class Main {
    public static void main(String[] args) {

        ErrorHandler errorHandler = new ErrorHandler();

        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user to enter file name for the name file 
            System.out.println("Enter the path to the student name file (e.g., NameFile.txt): ");
            String nameFile = scanner.nextLine().trim();

            // Immediately check if file exists and user input is not empty (offensive programming)
            File nameFileCheck = new File(nameFile);
            if (!nameFileCheck.exists() || nameFileCheck.length() == 0) {
                errorHandler.handle("Student name file not found or is empty: " + nameFile);
                scanner.close();
                return;
            }

            // Prompt user to enter file name for the course file 
            System.out.println("Enter the path to the course file (e.g., CourseFile.txt): ");
            String courseFile = scanner.nextLine().trim();

            // Immediately check if file exists and user input is not empty (offensive programming)
            File courseFileCheck = new File(courseFile);
            if (!courseFileCheck.exists() || courseFileCheck.length() == 0) {
                errorHandler.handle("Student name file not found or is empty: " + courseFile);
                scanner.close();
                return;
            }

            // Prompt user to enter output file name or use default
            System.out.print("Enter desired output file name (or press Enter to use 'results.txt'): ");
            String outputFile = scanner.nextLine().trim();
            if (outputFile.isEmpty()) {
                outputFile = "results.txt";
            }

            // Call the projectController class to run the project with the provided file names
            ProjectController controller = new ProjectController(new StudentParser(errorHandler), new CourseParser(errorHandler), new OutputGenerator(errorHandler), new OutputWriter(errorHandler), errorHandler);
            controller.run(nameFile, courseFile, outputFile);

            scanner.close();
        } catch(Exception e) {
            errorHandler.handle(e);
        }   
    }
}