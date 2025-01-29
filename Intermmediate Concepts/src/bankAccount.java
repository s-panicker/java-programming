public class bankAccount {
    class BankAccount {
        private double balance;

        // Getter for balance
        public double getBalance() {
            return balance;
        }

        // Method to deposit money
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        // Method to withdraw money
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        }
    }

    public class Main {
        public void main(String[] args) {
            BankAccount account = new BankAccount();
            account.deposit(100);
            account.withdraw(30);

            System.out.println("Balance: " + account.getBalance());
        }
    }
}
