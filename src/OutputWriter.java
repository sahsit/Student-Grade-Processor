import objects.outputRow;
import java.util.List;
import java.io.PrintWriter;
import java.io.IOException;

public class OutputWriter {
    
    // Write the results to a file
    public void output(List<outputRow> outputList, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {

            // Loop through the results list and write each field in (x, x, x, x) format
            for (outputRow row : outputList) {
                writer.printf("%d, %s, %s, %.1f%n", row.getStudentId(), row.getStudentName(), row.getCourseCode(), row.getFinalGrade());
            }

            // Console confirmation of success
            System.out.println("Output written to: " + fileName);
        } catch (IOException exception) {
            System.out.println("Error writing to file: " + exception.getMessage());
        }
    }
}