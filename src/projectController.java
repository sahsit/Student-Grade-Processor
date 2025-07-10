import java.util.List;
import java.util.HashMap;
import java.util.Map;
import objects.Course;
import objects.Student;
import parsers.courseParser;
import parsers.studentParser;
import objects.outputRow;


// This class orchestrates and runs the project workflow
public class projectController {
    private final studentParser studentParser = new studentParser();
    private final courseParser courseParser = new courseParser();
    private final OutputWriter outputWriter = new OutputWriter();
    
    public void run(String nameFile, String courseFile, String outputFile) {
        
        // Parse students and courses from input files
        List<Student> students = studentParser.parse(nameFile);
        List<Course> courses = courseParser.parse(courseFile);

        // If either list is empty, fail fast and loud (offensive programming)
        if (courses.isEmpty()) {
            throw new IllegalStateException("No courses loaded. Cannot proceed.");
        }
        if (students.isEmpty()) {
            throw new IllegalStateException("No students loaded. Cannot proceed.");
        }

        // Build a map of student ID to Student object for quick lookup
        Map<Integer, Student> studentMap = buildStudentMap(students);

        // Generate output rows and write to output file using the OutputWriter class
        List<outputRow> results = outputWriter.generateOutputRows(courses, studentMap);
        outputWriter.output(results, outputFile);

    }

    // Helper method to build a map of student ID to Student object
    private Map<Integer, Student> buildStudentMap(List<Student> students) {
        Map<Integer, Student> studentMap = new HashMap<>();
        for (Student s : students) {
            studentMap.put(s.getId(), s);
        } 
        return studentMap;
    }
}