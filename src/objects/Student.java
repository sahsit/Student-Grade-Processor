package objects;

// Student class with fields corresponding to input file information
public class Student {
    private String studentName;
    private int studentID;

    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    // Getters and setters for each field (encapsulation)
    public String getName() {
        return studentName;
    }

    public int getId() {
        return studentID;
    }

    // setters
    public void setName(String newName) {
        this.studentName = newName;
    }

    public void setID(int studentID) {
        this.studentID = studentID;
    }
}
