import java.util.Scanner;


public class bankDetails {


    class BankAccount {
        private String holderName;
        private double balance;

        // Constructor to initialize account holder's name and balance
        public BankAccount(String holderName, double balance) {
            this.holderName = holderName;
            this.balance = balance;
        }

        // Deposit method
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: $" + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        // Withdraw method
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: $" + amount);
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        }

        // Display balance
        public void displayBalance() {
            System.out.println("Current Balance: $" + balance);
        }
    }

    public class Main {
        public void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Create a new bank account for the user
            System.out.print("Enter account holder name: ");
            String name = scanner.nextLine();
            BankAccount account = new BankAccount(name, 0);  // Starting with $0 balance

            boolean exit = false;

            while (!exit) {
                System.out.println("\n1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        account.displayBalance();
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Exiting... Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            scanner.close();
        }
    }

}

