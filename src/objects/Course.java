package objects;


// Course class with fields corresponding to input file information
public class Course {
    private int studentID;
    private String courseCode;
    private int testOneGrade;
    private int testTwoGrade;
    private int testThreeGrade;
    private int finalTestGrade;

    public Course(int studentID, String courseCode, int testOneGrade, int testTwoGrade, int testThreeGrade, int finalTestGrade) {
        this.studentID = studentID;
        this.courseCode = courseCode;
        this.testOneGrade = testOneGrade;
        this.testTwoGrade = testTwoGrade;
        this.testThreeGrade = testThreeGrade;
        this.finalTestGrade = finalTestGrade;
    } 

    // Getters and setters for each field (encapsulation)
    public int getStudentID() {
        return studentID;
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

    public void setStudentId(int ID) {
        this.studentID = ID;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setTestOneGrade(int grade) {
        this.testOneGrade = grade;
    }

    public void setTestTwoGrade(int grade) {
        this.testTwoGrade = grade;
    }

    public void setTestThreeGrade(int grade) {
        this.testThreeGrade = grade;
    }
    
    public void setFinalTestGrade(int grade) {
        this.finalTestGrade = grade;
    }

}


