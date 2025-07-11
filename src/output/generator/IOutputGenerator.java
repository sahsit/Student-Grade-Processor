package output.generator;
import java.util.List;
import java.util.Map;
import objects.Course;
import objects.GradeOutputRow;
import objects.Student;

// Interface for generating output rows from a list of courses and a map of students
// This interface is used by high-level classes instead of directly using the OutputGenerator class
public interface IOutputGenerator {

    List<GradeOutputRow> generate(List<Course> courses, Map<Integer, Student> studentMap);

}
