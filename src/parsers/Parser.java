package parsers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// base class for parsing files - implements basic functionality of parsing through file 
public abstract class Parser<T> {
    
    public List<T> parse(String filePath) {
        
        // creates list of type T (to be defined by subclasses)
        List<T> result = new ArrayList<>();
        // reads file line by line and parses each line into an object of type T
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // While loop to ensure each line isn't null
            while ((line = reader.readLine()) != null) {
                // parseLine is an abstract method that subclasses must implement to define how to parse a line
                T parsedObject = parseLine(line);
                if (parsedObject != null) {
                    result.add(parsedObject);
                }
            }

        // if file is not found or cannot be read, prints error message (offensive programming)
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
            e.printStackTrace();
    
        }
        return result;
    }

    protected abstract T parseLine(String line);

}
