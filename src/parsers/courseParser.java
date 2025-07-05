package parsers;

import objects.Course;

// Parser for Course objects, extending the base Parser class
public class courseParser extends Parser<Course> {
    
    @Override
    protected Course parseLine(String line) {
        // Assumes each line is formatted as "studentId, courseCode, testOneGrade, testTwoGrade, testThreeGrade, finalTestGrade"
        String[] parts = line.split(",");
        // if line does not contain exactly 6 parts, returns error (offensive programming)
        if (parts.length != 6) {
            throw new IllegalArgumentException("Invalid course line format: " + line);
        }
        
        // Extract data from file row
        int studentId = Integer.parseInt(parts[0].trim());
        String courseCode = parts[1].trim();
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
