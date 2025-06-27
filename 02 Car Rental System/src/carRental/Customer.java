package carRental;
import java.util.*;


    // Customer.java
    /**
     * Represents a customer in the rental system
     */
    public class Customer {
        private String customerId;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String driverLicense;
        private List<Rental> rentalHistory;

        public Customer(String customerId, String firstName, String lastName,
                        String email, String phoneNumber, String driverLicense) {
            this.customerId = customerId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.driverLicense = driverLicense;
            this.rentalHistory = new ArrayList<>();
        }

        // Getters and Setters
        public String getCustomerId() { return customerId; }
        public void setCustomerId(String customerId) { this.customerId = customerId; }

        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPhoneNumber() { return phoneNumber; }
        public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

        public String getDriverLicense() { return driverLicense; }
        public void setDriverLicense(String driverLicense) { this.driverLicense = driverLicense; }

        public List<Rental> getRentalHistory() { return new ArrayList<>(rentalHistory); }

        public String getFullName() {
            return firstName + " " + lastName;
        }

        public void addRental(Rental rental) {
            rentalHistory.add(rental);
        }

        public Rental getCurrentRental() {
            for (Rental rental : rentalHistory) {
                if (rental.isActive()) {
                    return rental;
                }
            }
            return null;
        }

        public boolean hasActiveRental() {
            return getCurrentRental() != null;
        }

        public double getTotalSpent() {
            double total = 0.0;
            for (Rental rental : rentalHistory) {
                total += rental.getTotalCost();
            }
            return total;
        }

        @Override
        public String toString() {
            return String.format("Customer{ID='%s', Name='%s', Email='%s', Phone='%s', License='%s', Rentals=%d}",
                    customerId, getFullName(), email, phoneNumber, driverLicense, rentalHistory.size());
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Customer customer = (Customer) obj;
            return Objects.equals(customerId, customer.customerId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(customerId);
        }
    }


