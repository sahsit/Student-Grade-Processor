package objects;


// Course class with fields corresponding to input file information
public class Course {
    private int studentId;
    private String courseCode;
    private int testOneGrade;
    private int testTwoGrade;
    private int testThreeGrade;
    private int finalTestGrade;

    public Course(int studentId, String courseCode, int testOneGrade, int testTwoGrade, int testThreeGrade, int finalTestGrade) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.testOneGrade = testOneGrade;
        this.testTwoGrade = testTwoGrade;
        this.testThreeGrade = testThreeGrade;
        this.finalTestGrade = finalTestGrade;
    } 

    // Getters for each field
    public int getStudentId() {
        return studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getTestOneGrade() {
        return testOneGrade;
    }

    public int getTestTwoGrade() {
        return testTwoGrade;
    }

    public int getTestThreeGrade() {
        return testThreeGrade;
    }
    
    public int getFinalTestGrade() {
        return finalTestGrade;
    }

}


