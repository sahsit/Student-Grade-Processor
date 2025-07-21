package parsers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import utilities.ErrorHandler;

// base class for parsing files - 
// implements basic functionality 
// of parsing through file and meant 
// to be extended by child classes
public abstract class Parser<T> {
    
    protected final ErrorHandler errorHandler;

    public Parser(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public List<T> parse(String filePath) {
        
        // Creates list of type T (to be defined by subclasses)
        List<T> result = new ArrayList<>();
        // Reads file line by line and parses each line into an object of type T - to be defined by child classes as either a Student or Course object
        // Wrapping file reading process in try-catch block to ensure offensive programming
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // While loop to ensure each line isn't null
            while ((line = reader.readLine()) != null) {
                // parseLine is an abstract method that subclasses must implement to define how to parse a line
                T parsedObject = parseLine(line);
                
                // Failing loud and early if there is a line that wasn't parsed properly (offensive programming)
                if (parsedObject == null) {
                    errorHandler.handle("Parsing error: Line could not be parsed properly:\n" + line);
                }

                result.add(parsedObject);
            }

        // If file is not found or cannot be read, prints error message (offensive programming)
        } catch (IOException e) {
            errorHandler.handle("Error reading file: " + e.getMessage());
        }
        return result;
    }

    protected abstract T parseLine(String line);

}
