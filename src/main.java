// import objects.Student;
// import objects.outputRow;
// import objects.Course;
// import parsers.studentParser;
// import parsers.courseParser;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.HashMap;
// import java.util.Map;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter file name for the name file 
        System.out.println("Enter the path to the student name file (e.g., NameFile.txt): ");
        String nameFile = scanner.nextLine().trim();

        // TO DO: OFFENSIVE PROGRAMMING CHECK IF FILE EXISTS OR IF EMPTY

        // Prompt user to enter file name for the course file 
        System.out.println("Enter the path to the course file (e.g., CourseFile.txt): ");
        String courseFile = scanner.nextLine().trim();

        // TO DO: OFFENSIVE PROGRAMMING CHECK IF FILE EXISTS OR IF EMPTY

        // Prompt user to enter output file name or use default
        System.out.print("Enter desired output file name (or press Enter to use 'results.txt'): ");
        String outputFile = scanner.nextLine().trim();
        if (outputFile.isEmpty()) {
            outputFile = "results.txt";
        }

        // Call the projectController class
        projectController controller = new projectController();
        controller.run(nameFile, courseFile, outputFile);

        scanner.close();
    }
}