import java.util.Scanner;

public class Task3RemovingDuplicates {

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

        /* Create a new array for unique values */
        int[] unique = new int[size];
        int uniqueCount = 0;

        for (int i = 0; i < size; i++) {
            int value = numbers[i];
            boolean alreadySeen = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (unique[j] == value) {
                    alreadySeen = true;
                    break;
                }
            }

            if (!alreadySeen) {
                unique[uniqueCount] = value;
                uniqueCount++;
            }
        }

        System.out.println("The array without duplicates:");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(unique[i]);
            if (i < uniqueCount - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        scanner.close(); /* ...Close the scanner to free resources */
    }
}
