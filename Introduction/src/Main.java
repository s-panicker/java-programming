// Superclass Vehicle
class Vehicle {
    public void move() {
        System.out.println("Vehicle is moving");
    }
}

// Subclass Car extends Vehicle
class Car extends Vehicle {
    @Override
    public void move() {
        System.out.println("Car is driving");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Car object
        Car myCar = new Car();
        myCar.move();  // This will call the overridden method in the Car class
         // Output: Book Title: Java Basics, Author: John Doe
    }
}
