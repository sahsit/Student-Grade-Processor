import objects.Course;
import objects.Student;
import objects.outputRow;
import java.util.Comparator;
import java.util.List;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;



// This class abstracts file writing logic to be used in main
public class OutputWriter {
    
    public List<outputRow> generateOutputRows(List<Course> courses, Map<Integer, Student> studentMap) {
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
        return results;
    }


    // Write the results to a file
    public void output(List<outputRow> outputList, String fileName) {
        
        // Wrapping file writing process in try-catch block to ensure offensive programming
        try (PrintWriter writer = new PrintWriter(fileName)) {
            
            // Sorting the list by studentId 
            outputList.sort(Comparator.comparing(outputRow::getStudentId));

            // Loop through the results list and write each field in (x, x, x, x) format
            for (outputRow row : outputList) {
                writer.printf("%d, %s, %s, %.1f%n", row.getStudentId(), row.getStudentName(), row.getCourseCode(), row.getFinalGrade());
            }

            // Console confirmation of success
            System.out.println("Output successfully written to: " + fileName);
        } catch (IOException exception) {
            System.out.println("Error writing to file: " + exception.getMessage());
        }
    }
}
