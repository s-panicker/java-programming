package bookingSystem;

// Course.java
import java.util.*;

/**
 * Represents a course with enrolled students
 */
public class Course {
    private String courseCode;
    private String courseName;
    private String instructor;
    private int creditHours;
    private List<Student> enrolledStudents;

    public Course(String courseCode, String courseName, String instructor, int creditHours) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
        this.creditHours = creditHours;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getters and Setters
    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public int getCreditHours() { return creditHours; }
    public void setCreditHours(int creditHours) { this.creditHours = creditHours; }

    public List<Student> getEnrolledStudents() { return new ArrayList<>(enrolledStudents); }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public double calculateClassAverage() {
        if (enrolledStudents.isEmpty()) return 0.0;

        double total = 0.0;
        int count = 0;

        for (Student student : enrolledStudents) {
            Grade grade = student.getGrade(courseCode);
            if (grade != null) {
                total += grade.getNumericGrade();
                count++;
            }
        }

        return count > 0 ? total / count : 0.0;
    }

    @Override
    public String toString() {
        return String.format("Course{Code='%s', Name='%s', Instructor='%s', Credits=%d, Enrolled=%d}",
                courseCode, courseName, instructor, creditHours, enrolledStudents.size());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }
}
