import objects.outputRow;
import java.util.Comparator;
import java.util.List;
import java.io.PrintWriter;
import java.io.IOException;


// This class abstracts file writing logic to be used in main
public class OutputWriter {
    
    // Write the results to a file
    public void output(List<outputRow> outputList, String fileName) {
        
        // Wrapping file writing process in try-catch block to ensure offensive programming
        try (PrintWriter writer = new PrintWriter(fileName)) {
            
            outputList.sort(Comparator.comparing(outputRow::getStudentId));

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