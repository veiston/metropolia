import java.util.Scanner;

public class Task2MaximumSubarraySum {

    public static void main(String[] args) {
        /* Declare the scanner */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = Integer.parseInt(scanner.nextLine().trim());

        int[] numbers = new int[size];

        System.out.println("Enter the integers into the array:");
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter integer %d: ", i + 1);
            numbers[i] = Integer.parseInt(scanner.nextLine().trim());
        }

        /* Brute-force ...iterate through all possible subarrays */
        int bestSum = Integer.MIN_VALUE;
        int bestStart = 0;
        int bestEnd = 0;

        for (int start = 0; start < size; start++) {
            int sum = 0;
            for (int end = start; end < size; end++) {
                sum += numbers[end];
                if (sum > bestSum) {
                    bestSum = sum;
                    bestStart = start;
                    bestEnd = end;
                }
            }
        }

        System.out.println();
        System.out.println("Maximum sum: " + bestSum);
        System.out.printf("Integers: %d-%d%n", bestStart + 1, bestEnd + 1);

        scanner.close(); /* ...Close the scanner to free resources */
    }
}
