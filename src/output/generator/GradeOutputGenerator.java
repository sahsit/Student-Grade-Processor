package output.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import objects.Course;
import objects.Student;
import utilities.ErrorHandler;

public class GradeOutputGenerator {

    private final ErrorHandler errorHandler;
    
    public GradeOutputGenerator(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public List<OutputRow> generate(List<Course> courses, Map<Integer, Student> studentMap) {
            List<OutputRow> results = new ArrayList<>();

            // Loop through each course find the corresponding student
            for (Course c : courses) {
                Student s = studentMap.get(c.getStudentID());

                // If student is not found, fail fast and loud (offensive programming)
                if (s == null) {
                    errorHandler.handle("Student ID not found for course entry: " + c.getStudentID());
                }

                // Calculate the final grade using the utility method from GradeCalculator
                double finalGrade = GradeCalculator.computeFinalGrade(
                    c.getTestOneGrade(), c.getTestTwoGrade(), c.getTestThreeGrade(), c.getFinalTestGrade()
                );

                results.add(new OutputRow(s.getId(), s.getName(), c.getCourseCode(), finalGrade));
            }

            return results;
        }
    }
