package carRental;

import java.util.Objects;

public class Car {
    private String carId;
    private String brand;
    private String model;
    private int year;
    private String color;
    private double dailyRate;
    private boolean isAvailable;
    private String category; // Economy, Mid-size, Luxury, SUV

    public Car(String carId, String brand, String model, int year, String color,
               double dailyRate, String category) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.dailyRate = dailyRate;
        this.category = category;
        this.isAvailable = true; // N
}
    // Getters and Setters
    public String getCarId() { return carId; }
    public void setCarId(String carId) { this.carId = carId; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getCarDetails() {
        return String.format("%d %s %s (%s)", year, brand, model, color);
    }

    public void rentCar() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Car " + getCarDetails() + " has been rented.");
        } else {
            System.out.println("Car " + getCarDetails() + " is not available.");
        }
    }

    public void returnCar() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Car " + getCarDetails() + " has been returned.");
        } else {
            System.out.println("Car " + getCarDetails() + " was not rented.");
        }
    }

    @Override
    public String toString() {
        return String.format("Car{ID='%s', %s, Rate=$%.2f/day, Category='%s', Available=%s}",
                carId, getCarDetails(), dailyRate, category, isAvailable ? "Yes" : "No");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return Objects.equals(carId, car.carId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId);
    }
}