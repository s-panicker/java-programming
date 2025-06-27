classDiagram
class Student {
-String studentId
-String firstName
-String lastName
-String email
-Map<String, Grade> grades

        +Student(studentId: String, firstName: String, lastName: String, email: String)
        +getStudentId(): String
        +setStudentId(studentId: String): void
        +getFirstName(): String
        +setFirstName(firstName: String): void
        +getLastName(): String
        +setLastName(lastName: String): void
        +getEmail(): String
        +setEmail(email: String): void
        +getGrades(): Map<String, Grade>
        +getFullName(): String
        +addGrade(courseCode: String, grade: Grade): void
        +getGrade(courseCode: String): Grade
        +calculateGPA(): double
        +toString(): String
        +equals(obj: Object): boolean
        +hashCode(): int
    }
    
    class Grade {
        -String courseCode
        -String courseName
        -double numericGrade
        -String letterGrade
        -int creditHours
        -double gradePoints
        
        +Grade(courseCode: String, courseName: String, numericGrade: double, creditHours: int)
        +getCourseCode(): String
        +setCourseCode(courseCode: String): void
        +getCourseName(): String
        +setCourseName(courseName: String): void
        +getNumericGrade(): double
        +setNumericGrade(numericGrade: double): void
        +getLetterGrade(): String
        +getCreditHours(): int
        +setCreditHours(creditHours: int): void
        +getGradePoints(): double
        -calculateLetterGrade(numericGrade: double): String
        -calculateGradePoints(letterGrade: String): double
        +toString(): String
    }
    
    class Course {
        -String courseCode
        -String courseName
        -String instructor
        -int creditHours
        -List<Student> enrolledStudents
        
        +Course(courseCode: String, courseName: String, instructor: String, creditHours: int)
        +getCourseCode(): String
        +setCourseCode(courseCode: String): void
        +getCourseName(): String
        +setCourseName(courseName: String): void
        +getInstructor(): String
        +setInstructor(instructor: String): void
        +getCreditHours(): int
        +setCreditHours(creditHours: int): void
        +getEnrolledStudents(): List<Student>
        +enrollStudent(student: Student): void
        +removeStudent(student: Student): void
        +calculateClassAverage(): double
        +toString(): String
        +equals(obj: Object): boolean
        +hashCode(): int
    }
    
    class GradeManager {
        -Map<String, Student> students
        -Map<String, Course> courses
        -Scanner scanner
        
        +GradeManager()
        +addStudent(student: Student): void
        +getStudent(studentId: String): Student
        +removeStudent(studentId: String): void
        +addCourse(course: Course): void
        +getCourse(courseCode: String): Course
        +removeCourse(courseCode: String): void
        +addGrade(studentId: String, courseCode: String, numericGrade: double): void
        +displayStudentReport(studentId: String): void
        +displayCourseReport(courseCode: String): void
        +displayAllStudents(): void
        +displayAllCourses(): void
        +runInteractiveMenu(): void
        -displayMenu(): void
        -handleAddStudent(): void
        -handleAddCourse(): void
        -handleAddGrade(): void
        -handleStudentReport(): void
        -handleCourseReport(): void
        -handleRemoveStudent(): void
        -handleRemoveCourse(): void
        -getIntInput(prompt: String): int
        -getDoubleInput(prompt: String): double
        +main(args: String[]): void
    }
    
    %% Relationships
    Student "1" --* "0..*" Grade : contains
    Course "1" --* "0..*" Student : enrolls
    GradeManager "1" --* "0..*" Student : manages
    GradeManager "1" --* "0..*" Course : manages
    Grade --> Course : references
    
    %% Notes for relationships
    Student : "Each student can have multiple grades"
    Course : "Each course can have multiple enrolled students"
    Grade : "Each grade belongs to one student and references one course"
    GradeManager : "Main controller class that manages all students and courses"