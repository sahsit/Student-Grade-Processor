package objects;


// Student class with fields corresponding to input file information
public class Student {
    private String studentName;
    private int studentId;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    // Getters and setters for each field     
    public String getName() {
        return studentName;
    }

    public void setName(String newName) {
        this.studentName = newName;
    }

    public int getId() {
        return studentId;
    }

}
