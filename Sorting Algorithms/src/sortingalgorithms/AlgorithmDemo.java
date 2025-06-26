package sortingalgorithms;

import java.util.Arrays;
import java.util.Scanner;

// Main class to demonstrate all algorithms
public class AlgorithmDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Simple Algorithms Demo ===\n");

        // Demo array for sorting and searching
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 5};
        System.out.println("Original array: " + Arrays.toString(arr));

        // Sorting Algorithms Demo
        int[] bubbleArr = arr.clone();
        SortingAlgorithms.bubbleSort(bubbleArr);
        System.out.println("Bubble Sort result: " + Arrays.toString(bubbleArr));

        int[] selectionArr = arr.clone();
        SortingAlgorithms.selectionSort(selectionArr);
        System.out.println("Selection Sort result: " + Arrays.toString(selectionArr));

    }
}