package output.writer;
import java.util.ArrayList;
import objects.GradeOutputRow;
import utilities.ErrorHandler;

public abstract class OutputWriter {
    
    protected final ErrorHandler errorHandler;

    public OutputWriter(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }
    
    public abstract void output(ArrayList<GradeOutputRow> outputList, String fileName);

}
