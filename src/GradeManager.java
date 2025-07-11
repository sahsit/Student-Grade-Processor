import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import objects.Course;
import objects.GradeOutputRow;
import objects.Student;
import output.writer.GradeOutputWriter;
import parsers.Parser;
import utilities.ErrorHandler;

public class GradeManager {

    private final Parser<Course> courseParser;
    private final Parser<Student> studentParser;
    private final ErrorHandler errorHandler;
    
    public GradeManager(Parser<Course> courseParser, Parser<Student> studentParser) {
        this.courseParser = courseParser;
        this.studentParser = studentParser;
        this.errorHandler = new ErrorHandler();
    }

    public void manage(String nameFilePath, String courseFilePath) {
        ArrayList<Course> courses = courseParser.parse(courseFilePath);
        ArrayList<Student> students = studentParser.parse(nameFilePath);

        ArrayList<GradeOutputRow> results = new ArrayList<>();

        Map<Integer, Student> studentMap = new HashMap<>();
        for (Student student : students) {
            studentMap.put(student.getID(), student);
        }

        // Loop through each course find the corresponding student
        for (Course course : courses) {
            Student student = studentMap.get(course.getStudentID());

            // If student is not found, fail fast and loud (offensive programming)
            if (student == null) {
                errorHandler.handle("Student ID not found for course entry: " + course.getStudentID());
            }

            // Calculate the final grade using the utility method from GradeCalculator
            double finalGrade = GradeCalculator.computeFinalGrade(
                course.getTestOneGrade(), course.getTestTwoGrade(), course.getTestThreeGrade(), course.getFinalTestGrade()
            );

            results.add(new GradeOutputRow(student.getID(), student.getName(), course.getCourseCode(), finalGrade));
        }

        GradeOutputWriter gradeWriter = new GradeOutputWriter(new ErrorHandler());
        gradeWriter.output(results, "Results.txt");
    }

}
