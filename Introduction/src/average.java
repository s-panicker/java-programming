public class average {
    public static void main(String[] args) {
        // Array of numbers
        int[] numbers = {10, 20, 30, 40, 50};

        // Call the method to calculate average
        double avg = calculateAverage(numbers);

        // Print the average
        System.out.println("The average is: " + avg);
    }

    // Method to calculate average of an array of integers
    public static double calculateAverage(int[] numbers) {
        int sum = 0;

        // Calculate the sum of the array elements
        for (int num : numbers) {
            sum += num;
        }

        // Calculate and return the average
        return (double) sum / numbers.length;
    }
}
