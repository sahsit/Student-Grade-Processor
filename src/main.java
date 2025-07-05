import objects.Student;
import objects.outputRow;
import objects.Course;
import parsers.studentParser;
import parsers.courseParser;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        // Create instance of parsers
        studentParser studentParser = new studentParser();
        courseParser courseParser = new courseParser();

        // Parse the student and course files, storing them in Lists  
        List<Student> students = studentParser.parse("NameFile.txt");
        List<Course> courses = courseParser.parse("CourseFile.txt");

        // If either list is empty, the code fails and returns an error (offensive programming)
        if (courses.isEmpty()) {
            throw new IllegalStateException("No courses loaded. Cannot proceed.");
        }
        if (students.isEmpty()) {
            throw new IllegalStateException("No students loaded. Cannot proceed.");
        }

        // Create a hashmap to store (studentId, Student object) for O(1) lookup
        Map<Integer, Student> studentMap = new HashMap<>();
        for (Student s : students) {
            studentMap.put(s.getId(), s);
        } 

        // Create an empty List made of outputRow objects for output
        List<outputRow> results = new ArrayList<>();

        // For each row from CourseFile.txt...
        for (Course c : courses) {
            // ... find the corresponding Student object using the hashmap...
            Student s = studentMap.get(c.getStudentID());
            
            // ... check if the student for that studentID exists... (offensive programming)
            if (s == null) {
                throw new RuntimeException("Student ID not found for course entry: " + c.getStudentID());
            }

            // ... calculate the final grade ...
            double finalGrade = gradeCalculator.computeFinalGrade(c.getTestOneGrade(), c.getTestTwoGrade(), c.getTestThreeGrade(), c.getFinalTestGrade());
            // ... and store that data in an outputRow object, adding that object into the results list 
            results.add(new outputRow(s.getId(), s.getName(), c.getCourseCode(), finalGrade));
        }

        // Writing the resulting list into a file 
        OutputWriter writer = new OutputWriter();
        writer.output(results, "results.txt");

    }
}