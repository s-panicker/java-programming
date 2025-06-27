package carRental;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();

        // Add sample data
        system.addCar(new Car("C001", "Toyota", "Camry", 2023, "White", 45.0, "Mid-size"));
        system.addCar(new Car("C002", "Honda", "Civic", 2022, "Blue", 40.0, "Economy"));
        system.addCar(new Car("C003", "BMW", "X5", 2023, "Black", 85.0, "Luxury"));
        system.addCar(new Car("C004", "Ford", "Explorer", 2022, "Red", 65.0, "SUV"));
        system.addCar(new Car("C005", "Nissan", "Altima", 2023, "Silver", 42.0, "Mid-size"));

        system.addCustomer(new Customer("CU001", "John", "Doe", "john.doe@email.com", "555-1234", "DL123456"));
        system.addCustomer(new Customer("CU002", "Jane", "Smith", "jane.smith@email.com", "555-5678", "DL789012"));
        system.addCustomer(new Customer("CU003", "Bob", "Johnson", "bob.johnson@email.com", "555-9012", "DL345678"));

        // Create some sample rentals
        system.rentCar("CU001", "C001", LocalDate.now().minusDays(2), LocalDate.now().plusDays(3));
        system.rentCar("CU002", "C003", LocalDate.now().minusDays(1), LocalDate.now().plusDays(7));

        System.out.println("Welcome to Car Rental System!");
        System.out.println("Sample data has been loaded.");

        // Run interactive menu
        system.runInteractiveMenu();
    }
}
