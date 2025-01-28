public class ageException {
    class AgeException extends Exception {
        public AgeException(String message) {
            super(message);
        }
    }

    public class Main {
        public static void main(String[] args) {
            try {
                checkAge(16);  // Will throw AgeException
            } catch (AgeException e) {
                System.out.println("Error: " + e.getMessage());  // Output: Error: Age must be 18 or older.
            }
        }

        public void checkAge(int age) throws AgeException {
            if (age < 18) {
                throw new AgeException("Age must be 18 or older.");
            }
            System.out.println("Age is valid.");
        }
    }
}
