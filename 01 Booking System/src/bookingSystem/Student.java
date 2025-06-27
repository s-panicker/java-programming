package bookingSystem;
import java.util.*;

public class Student {private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private Map<String, Grade> grades;

    public Student(String studentId, String firstName, String lastName, String email) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.grades = new HashMap<>();
}

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Map<String, Grade> getGrades() { return grades; }
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void addGrade(String courseCode, Grade grade) {
        grades.put(courseCode, grade);
    }

    public Grade getGrade(String courseCode) {
        return grades.get(courseCode);
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;

        double totalPoints = 0.0;
        int totalCredits = 0;

        for (Grade grade : grades.values()) {
            totalPoints += grade.getGradePoints() * grade.getCreditHours();
            totalCredits += grade.getCreditHours();
        }

        return totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }

    @Override
    public String toString() {
        return String.format("Student{ID='%s', Name='%s', Email='%s', GPA=%.2f}",
                studentId, getFullName(), email, calculateGPA());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}