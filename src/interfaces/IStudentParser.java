package interfaces;
import java.util.List;
import objects.Student;

// Interface for parsing student data from a file
// Used by high-level classes instead of directly using the StudentParser class
public interface IStudentParser {
    List<Student> parse(String filePath);
}
