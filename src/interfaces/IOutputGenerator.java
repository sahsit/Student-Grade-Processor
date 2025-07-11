package interfaces;
import java.util.List;
import java.util.Map;
import objects.Course;
import objects.Student;
import objects.OutputRow;

// Interface for generating output rows from a list of courses and a map of students
// This interface is used by high-level classes instead of directly using the OutputGenerator class
public interface IOutputGenerator {
    List<OutputRow> generate(List<Course> courses, Map<Integer, Student> studentMap);
}
