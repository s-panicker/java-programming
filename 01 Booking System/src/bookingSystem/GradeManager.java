package bookingSystem;

import java.util.*;

/**
 * Main class that manages students, courses, and grades
 */
public class GradeManager {
    private Map<String, Student> students;
    private Map<String, Course> courses;
    private Scanner scanner;

    public GradeManager() {
        this.students = new HashMap<>();
        this.courses = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    // Student Management
    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
        System.out.println("Student added successfully: " + student.getFullName());
    }

    public Student getStudent(String studentId) {
        return students.get(studentId);
    }

    public void removeStudent(String studentId) {
        Student student = students.remove(studentId);
        if (student != null) {
            // Remove student from all courses
            for (Course course : courses.values()) {
                course.removeStudent(student);
            }
            System.out.println("Student removed successfully: " + student.getFullName());
        } else {
            System.out.println("Student not found with ID: " + studentId);
        }
    }
}