import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    // Constructor
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    // Display student info
    public void display() {
        System.out.println("Name: " + name + ", Grade: " + grade);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Average Grade");
            System.out.println("4. Find Highest/Lowest Grade");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student grade: ");
                    double grade = scanner.nextDouble();
                    students.add(new Student(name, grade));
                    break;
                case 2:
                    System.out.println("\nStudent List:");
                    for (Student student : students) {
                        student.display();
                    }
                    break;
                case 3:
                    double total = 0;
                    for (Student student : students) {
                        total += student.grade;
                    }
                    System.out.println("Average Grade: " + (total / students.size()));
                    break;
                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students to check.");
                    } else {
                        double highest = students.get(0).grade;
                        double lowest = students.get(0).grade;
                        for (Student student : students) {
                            if (student.grade > highest) highest = student.grade;
                            if (student.grade < lowest) lowest = student.grade;
                        }
                        System.out.println("Highest Grade: " + highest);
                        System.out.println("Lowest Grade: " + lowest);
                    }
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
