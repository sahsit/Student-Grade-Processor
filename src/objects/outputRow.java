package objects;

public class outputRow {
    private int studentId;
    private String studentName;
    private String courseCode;
    private double finalGrade;

    public outputRow(int studentId, String studentName, String courseCode, double finalGrade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseCode = courseCode;
        this.finalGrade = finalGrade;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public double getFinalGrade() {
        return finalGrade;
    }
}
