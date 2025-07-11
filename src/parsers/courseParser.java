package parsers;   

import interfaces.ICourseParser;
import objects.Course;
import utilities.ErrorHandler;

// Parser for Course objects, extending the base Parser class
public class CourseParser extends Parser<Course> implements ICourseParser {
    
    public CourseParser(ErrorHandler errorHandler) {
        super(errorHandler);
    }

    @Override
    protected Course parseLine(String line) {
        // Assumes each line is formatted as "studentId, courseCode, testOneGrade, testTwoGrade, testThreeGrade, finalTestGrade"
        String[] parts = line.split(",");
        // if line does not contain exactly 6 parts, returns error (offensive programming)
        if (parts.length != 6) {
            errorHandler.handle("Invalid course line format: " + line);
        }
        
        // Student ID is extracted as a string to check if it's 9 digits
        String idCheck = parts[0].trim();
        // Failing early and loud if the student ID is not 9 digits (offensive programming)
        if (!idCheck.matches("\\d{9}")) {
            throw new IllegalArgumentException("Invalid student ID (must be 9 digits): " + idCheck);
        }
        // Converting student ID to integer
        int studentId = Integer.parseInt(parts[0].trim());
        
        // Extracting course code 
        String courseCode = parts[1].trim();
        if (!courseCode.matches("^[A-Za-z]{2}\\d{3}$")) {
            throw new IllegalArgumentException("Invalid course code (must be 2 letters followed by 3 digits): " + courseCode);
        }

        // Extracting the remaining data (these will be validated below)
        int testOneGrade = Integer.parseInt(parts[2].trim());
        int testTwoGrade = Integer.parseInt(parts[3].trim());
        int testThreeGrade = Integer.parseInt(parts[4].trim());
        int finalTestGrade = Integer.parseInt(parts[5].trim());

        if (testOneGrade < 0 || testOneGrade > 100 || testTwoGrade < 0 || testTwoGrade > 100 || testThreeGrade < 0 || testThreeGrade > 100 || finalTestGrade < 0 || finalTestGrade > 100) {
            throw new IllegalArgumentException("Invalid grade detected for student ID: " + studentId);
        }

        // Store in a Course object
        return new Course(studentId, courseCode, testOneGrade, testTwoGrade, testThreeGrade, finalTestGrade);

    }

}
