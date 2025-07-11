
// This class abstracts grade calculating logic to be used in main
public class GradeCalculator {
    
    // Calculate overall course grade from individual grades
    public static double computeFinalGrade(int t1, int t2, int t3, int finalExam) {
        double result = ((t1+t2+t3) * 0.2) + (finalExam * 0.4);
        return round(result, 1);
    }

    // Private helper function to round to one decimal point
    private static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value*scale)/scale;
    }

}
