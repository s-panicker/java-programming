public class Person1 {
    // Instance variables (attributes)
    String name;
    int age;

    // Constructor to initialize name and age
    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display person's details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Person {
    public static void main(String[] args) {
        // Create an object of Person
        Person person1 = new Person("Alice", 25);

        // Call the method to display details
        person1.displayDetails();
    }
}
