package carRental;


import java.time.LocalDate;
import java.util.*;

/**
 * Main class that manages the car rental syste*/
public class CarRentalSystem {
    private Map<String, Car> cars;
    private Map<String, Customer> customers;
    private Map<String, Rental> rentals;
    private Scanner scanner;
    private int nextRentalId;

    public CarRentalSystem() {
        this.cars = new HashMap<>();
        this.customers = new HashMap<>();
        this.rentals = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.nextRentalId = 1;
    }

    // Car Management
    public void addCar(Car car) {
        cars.put(car.getCarId(), car);
        System.out.println("Car added successfully: " + car.getCarDetails());
    }

    public Car getCar(String carId) {
        return cars.get(carId);
    }

    public void removeCar(String carId) {
        Car car = cars.remove(carId);
        if (car != null) {
            System.out.println("Car removed successfully: " + car.getCarDetails());
        } else {
            System.out.println("Car not found with ID: " + carId);
        }
    }

    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars.values()) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public List<Car> getCarsByCategory(String category) {
        List<Car> categoryCars = new ArrayList<>();
        for (Car car : cars.values()) {
            if (car.getCategory().equalsIgnoreCase(category) && car.isAvailable()) {
                categoryCars.add(car);
            }
        }
        return categoryCars;
    }

    // Customer Management
    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
        System.out.println("Customer added successfully: " + customer.getFullName());
    }

    public Customer getCustomer(String customerId) {
        return customers.get(customerId);
    }

    public void removeCustomer(String customerId) {
        Customer customer = customers.remove(customerId);
        if (customer != null) {
            System.out.println("Customer removed successfully: " + customer.getFullName());
        } else {
            System.out.println("Customer not found with ID: " + customerId);
        }
    }

    // Rental Management
    public String rentCar(String customerId, String carId, LocalDate startDate, LocalDate endDate) {
        Customer customer = getCustomer(customerId);
        Car car = getCar(carId);

        if (customer == null) {
            System.out.println("Customer not found with ID: " + customerId);
            return null;
        }

        if (car == null) {
            System.out.println("Car not found with ID: " + carId);
            return null;
        }

        if (!car.isAvailable()) {
            System.out.println("Car is not available for rent: " + car.getCarDetails());
            return null;
        }

        if (customer.hasActiveRental()) {
            System.out.println("Customer already has an active rental: " + customer.getFullName());
            return null;
        }

        String rentalId = "R" + String.format("%03d", nextRentalId++);
        Rental rental = new Rental(rentalId, customer, car, startDate, endDate);

        rentals.put(rentalId, rental);
        customer.addRental(rental);
        car.rentCar();

        System.out.println("Car rented successfully!");
        System.out.println(rental);
        return rentalId;
    }

    public void returnCar(String rentalId) {
        Rental rental = rentals.get(rentalId);
        if (rental == null) {
            System.out.println("Rental not found with ID: " + rentalId);
            return;
        }

        if (!rental.isActive()) {
            System.out.println("Rental is not active: " + rentalId);
            return;
        }

        rental.completeRental();
        System.out.println("Car returned successfully!");
        System.out.println("Final cost: $" + String.format("%.2f", rental.getTotalCost()));

        if (rental.isOverdue()) {
            System.out.println("Warning: Car was " + rental.getOverdueDays() + " days overdue!");
        }
    }

    public void cancelRental(String rentalId) {
        Rental rental = rentals.get(rentalId);
        if (rental == null) {
            System.out.println("Rental not found with ID: " + rentalId);
            return;
        }

        if (!rental.isActive()) {
            System.out.println("Rental is not active: " + rentalId);
            return;
        }

        rental.cancelRental();
        System.out.println("Rental cancelled successfully: " + rentalId);
    }

    // Reporting Methods
    public void displayAvailableCars() {
        System.out.println("\n=== Available Cars ===");
        List<Car> availableCars = getAvailableCars();
        if (availableCars.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }

        availableCars.sort(Comparator.comparing(Car::getCategory).thenComparing(Car::getDailyRate));
        for (Car car : availableCars) {
            System.out.println(car);
        }
    }

    public void displayCustomerRentals(String customerId) {
        Customer customer = getCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found with ID: " + customerId);
            return;
        }

        System.out.println("\n=== Customer Rental History ===");
        System.out.println("Customer: " + customer.getFullName());
        System.out.println("Total Spent: $" + String.format("%.2f", customer.getTotalSpent()));

        List<Rental> history = customer.getRentalHistory();
        if (history.isEmpty()) {
            System.out.println("No rental history found.");
            return;
        }

        System.out.println("\nRental History:");
        for (Rental rental : history) {
            System.out.println("  " + rental);
        }
    }

    public void displayAllRentals() {
        System.out.println("\n=== All Rentals ===");
        if (rentals.isEmpty()) {
            System.out.println("No rentals found.");
            return;
        }

        for (Rental rental : rentals.values()) {
            System.out.println(rental);
        }
    }

    public void displayOverdueRentals() {
        System.out.println("\n=== Overdue Rentals ===");
        boolean hasOverdue = false;

        for (Rental rental : rentals.values()) {
            if (rental.isOverdue()) {
                System.out.println(rental + " (Overdue by " + rental.getOverdueDays() + " days)");
                hasOverdue = true;
            }
        }

        if (!hasOverdue) {
            System.out.println("No overdue rentals.");
        }


    }


    // Interactive Menu System
    public void runInteractiveMenu() {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1: handleAddCar(); break;
                case 2: handleAddCustomer(); break;
                case 3: handleRentCar(); break;
                case 4: handleReturnCar(); break;
                case 5: displayAvailableCars(); break;
                case 6: handleCustomerRentals(); break;
                case 7: displayAllRentals(); break;
                case 8: displayOverdueRentals(); break;
                case 9: handleCancelRental(); break;
                case 0: running = false; break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using Car Rental System!");
    }

    private void displayMenu() {
        System.out.println("\n=== Car Rental System Menu ===");
        System.out.println("1. Add Car");
        System.out.println("2. Add Customer");
        System.out.println("3. Rent Car");
        System.out.println("4. Return Car");
        System.out.println("5. View Available Cars");
        System.out.println("6. View Customer Rentals");
        System.out.println("7. View All Rentals");
        System.out.println("8. View Overdue Rentals");
        System.out.println("9. Cancel Rental");
        System.out.println("0. Exit");
    }

    private void handleAddCar() {
        System.out.print("Enter car ID: ");
        String carId = scanner.nextLine();
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        int year = getIntInput("Enter year: ");
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        double dailyRate = getDoubleInput("Enter daily rate: ");
        System.out.print("Enter category (Economy/Mid-size/Luxury/SUV): ");
        String category = scanner.nextLine();

        Car car = new Car(carId, brand, model, year, color, dailyRate, category);
        addCar(car);
    }

    private void handleAddCustomer() {
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter driver license: ");
        String driverLicense = scanner.nextLine();

        Customer customer = new Customer(customerId, firstName, lastName, email, phoneNumber, driverLicense);
        addCustomer(customer);
    }

    private void handleRentCar() {
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter car ID: ");
        String carId = scanner.nextLine();
        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDateStr = scanner.nextLine();
        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDateStr = scanner.nextLine();

        try {
            LocalDate startDate = LocalDate.parse(startDateStr);
            LocalDate endDate = LocalDate.parse(endDateStr);
            rentCar(customerId, carId, startDate, endDate);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
        }
    }

    private void handleReturnCar() {
        System.out.print("Enter rental ID: ");
        String rentalId = scanner.nextLine();
        returnCar(rentalId);
    }

    private void handleCustomerRentals() {
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        displayCustomerRentals(customerId);
    }

    private void handleCancelRental() {
        System.out.print("Enter rental ID to cancel: ");
        String rentalId = scanner.nextLine();
        cancelRental(rentalId);
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}