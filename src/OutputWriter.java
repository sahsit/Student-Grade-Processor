import objects.OutputRow;
import utilities.ErrorHandler;
import java.util.Comparator;
import java.util.List;
import interfaces.IOutputWriter;
import java.io.PrintWriter;
import java.io.IOException;


// This class abstracts file writing logic to be used in main
public class OutputWriter implements IOutputWriter {
    private final ErrorHandler errorHandler;
    public OutputWriter(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    @Override
    // Method to output the list of OutputRow objects to a specified file
    public void output(List<OutputRow> outputList, String fileName) {
        
        // Wrapping file writing process in try-catch block to ensure offensive programming
        try (PrintWriter writer = new PrintWriter(fileName)) {
            
            // Sorting the list by studentId 
            outputList.sort(Comparator.comparing(OutputRow::getStudentId));

            // Loop through the results list and write each field in (x, x, x, x) format
            for (OutputRow row : outputList) {
                writer.printf("%d, %s, %s, %.1f%n", row.getStudentId(), row.getStudentName(), row.getCourseCode(), row.getFinalGrade());
            }

            // Console confirmation of success
            System.out.println("Output successfully written to: " + fileName);
        } catch (IOException exception) {
            errorHandler.handle("Error writing to file: " + exception.getMessage());
        }
    }
}
