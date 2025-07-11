import java.util.List;
import java.util.HashMap;
import java.util.Map;

import interfaces.ICourseParser;
import interfaces.IStudentParser;
import interfaces.IOutputGenerator;
import interfaces.IOutputWriter;
import objects.Course;
import objects.Student;
import utilities.ErrorHandler;
import objects.OutputRow;

// This class orchestrates and runs the project workflow
public class ProjectController {
    
    // Instance variables for the various parsers and output handlers
    private final IStudentParser studentParser;
    private final ICourseParser courseParser;
    private final IOutputGenerator generator;
    private final IOutputWriter writer;
    private final ErrorHandler errorHandler;
    
    // Constructor to initialize the parsers and output handlers
    public ProjectController(IStudentParser studentParser, ICourseParser courseParser, IOutputGenerator generator, IOutputWriter writer, ErrorHandler errorHandler) {
        this.studentParser = studentParser;
        this.courseParser = courseParser;
        this.generator = generator;
        this.writer = writer;
        this.errorHandler = errorHandler;
    }

    // Main method to run the project workflow
    public void run(String nameFile, String courseFile, String outputFile) {
        
        // Parse students and courses from input files
        List<Student> students = studentParser.parse(nameFile);
        List<Course> courses = courseParser.parse(courseFile);

        // If either list is empty, fail fast and loud (offensive programming)
        if (courses.isEmpty()) {
            errorHandler.handle("No courses loaded. Cannot proceed.");
        }
        if (students.isEmpty()) {
            errorHandler.handle("No students loaded. Cannot proceed.");
        }

        // Build a map of student ID to Student object for quick lookup
        Map<Integer, Student> studentMap = buildStudentMap(students);

        // Generate output rows to be written to the results.txt file using the OutputGenerator class
        List<OutputRow> results = generator.generate(courses, studentMap);
        
        // Write the results to the specified output file using the OutputWriter class
        writer.output(results, outputFile);

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