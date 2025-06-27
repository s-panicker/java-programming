package carRental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represents a rental transaction
 */
public class Rental {
    private String rentalId;
    private Customer customer;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate actualReturnDate;
    private double totalCost;
    private boolean isActive;
    private String status; // "Active", "Completed", "Cancelled"

    public Rental(String rentalId, Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = true;
        this.status = "Active";
        this.totalCost = calculateTotalCost();
    }

    // Getters and Setters
    public String getRentalId() { return rentalId; }
    public void setRentalId(String rentalId) { this.rentalId = rentalId; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public LocalDate getActualReturnDate() { return actualReturnDate; }
    public void setActualReturnDate(LocalDate actualReturnDate) { this.actualReturnDate = actualReturnDate; }

    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public long getRentalDays() {
        return ChronoUnit.DAYS.between(startDate, endDate) + 1; // +1 to include both start and end days
    }

    public double calculateTotalCost() {
        return getRentalDays() * car.getDailyRate();
    }

    public void completeRental() {
        this.actualReturnDate = LocalDate.now();
        this.isActive = false;
        this.status = "Completed";
        this.car.returnCar();

        // Calculate actual cost based on return date
        long actualDays = ChronoUnit.DAYS.between(startDate, actualReturnDate) + 1;
        this.totalCost = actualDays * car.getDailyRate();
    }

    public void cancelRental() {
        this.isActive = false;
        this.status = "Cancelled";
        this.car.returnCar();
        this.totalCost = 0.0; // No charge for cancelled rentals
    }

    public boolean isOverdue() {
        return isActive && LocalDate.now().isAfter(endDate);
    }

    public long getOverdueDays() {
        if (!isOverdue()) return 0;
        return ChronoUnit.DAYS.between(endDate, LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("Rental{ID='%s', Customer='%s', Car='%s', Period=%s to %s, Days=%d, Cost=$%.2f, Status='%s'}",
                rentalId, customer.getFullName(), car.getCarDetails(),
                startDate, endDate, getRentalDays(), totalCost, status);
    }
}
