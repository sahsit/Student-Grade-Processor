package objects;

public class GradeOutputRow {
    final private int studentId;
    final private String studentName;
    final private String courseCode;
    final private double finalGrade;

    public GradeOutputRow(int studentId, String studentName, String courseCode, double finalGrade) {
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
