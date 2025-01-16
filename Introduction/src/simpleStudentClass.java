public class simpleStudentClass {class Student {
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public void displayStudentInfo() {
        System.out.println("Student: " + name + ", Grade: " + grade);
    }
}

    public class Main {
        public void main(String[] args) {
            Student student1 = new Student("Bob", 85);
            student1.displayStudentInfo();  // Output: Student: Bob, Grade: 85
        }
    }


}
