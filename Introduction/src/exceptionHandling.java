public class exceptionHandling {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;  // This will cause division by zero error

        try {
            int result = num1 / num2;  // This will throw an exception
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        }
    }
}
