package interfaces;
import java.util.List;
import objects.Course;

// Interface for parsing course data from a file
// Used by high level classes instead of directly using the CourseParser class
public interface ICourseParser {
    List<Course> parse(String filePath);
}
