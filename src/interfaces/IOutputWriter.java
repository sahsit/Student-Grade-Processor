package interfaces;
import java.util.List;
import objects.OutputRow;

// Interface for writing output rows to a file
// This interface is used by high-level classes instead of directly using the OutputWriter class
public interface IOutputWriter {
    void output(List<OutputRow> outputList, String fileName);
}
