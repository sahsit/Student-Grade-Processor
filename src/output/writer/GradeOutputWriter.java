package output.writer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import objects.GradeOutputRow;
import utilities.ErrorHandler;

public class GradeOutputWriter extends OutputWriter {

    public GradeOutputWriter(ErrorHandler errorHandler) {
        super(errorHandler);
    }

    @Override
    public void output(ArrayList<GradeOutputRow> outputList, String fileName) {
        // Wrapping file writing process in try-catch block to ensure offensive programming
        try (PrintWriter writer = new PrintWriter(fileName)) {
            
            // Sorting the list by studentId 
            outputList.sort(Comparator.comparing(GradeOutputRow::getStudentId));

            // Loop through the results list and write each field in (x, x, x, x) format
            for (GradeOutputRow row : outputList) {
                writer.printf("%d, %s, %s, %.1f%n", row.getStudentId(), row.getStudentName(), row.getCourseCode(), row.getFinalGrade());
            }

            // Console confirmation of success
            System.out.println("Output successfully written to: " + fileName);
        } catch (IOException exception) {
            errorHandler.handle("Error writing to file: " + exception.getMessage());
        }
    }
}
