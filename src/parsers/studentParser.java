package parsers;

import objects.Student;

// Parser for Student objects, extending the base Parser class
public class studentParser extends Parser<Student> {
    
    @Override
    protected Student parseLine(String line) {
        // Assumes each line is formatted as "studentId, studentName"
        String[] parts = line.split(",");
        // if line does not contain exactly two parts, returns null (offensive programming)
        if (parts.length != 2) {
            return null;
        }
        
        int studentId = Integer.parseInt(parts[0].trim());
        String name = parts[1].trim();

        return new Student(studentId, name);

    }

}
