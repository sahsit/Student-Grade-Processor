package parsers;

import objects.Student;
import utilities.ErrorHandler;

// Parser for Student objects, extending the base Parser class
public class StudentParser extends Parser<Student> {

    public  StudentParser(ErrorHandler errorHandler) {
        super(errorHandler);
    }

    @Override
    public Student parseLine(String line) {
        // Assumes each line is formatted as "studentId, studentName"
        String[] parts = line.split(",");
        
        // If line does not contain exactly two parts, returns error (offensive programming)
        if (parts.length != 2) {
            errorHandler.handle("Invalid student line format: " + line);
        }

        // Student ID is extracted as a string to check if it's 9 digits
        String idCheck = parts[0].trim();
        
        // Failing early and loud if the student ID is not 9 digits (offensive programming)
        if (!idCheck.matches("\\d{9}")) {
            errorHandler.handle("Invalid student ID (must be 9 digits): " + idCheck);
        }

        // Converting student ID to integer 
        int studentId = Integer.parseInt(parts[0].trim());

        // Extract student name from line
        String name = parts[1].trim();

        // Store data in Student object
        return new Student(studentId, name);

    }

}
