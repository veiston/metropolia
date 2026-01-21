
import java.util.Scanner;

public class Task2BinaryValues {
    public static void main(String[] args) {
        /* Declare the scanner */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give the binary number");
        String binary = scanner.nextLine().trim();
        
        scanner.close(); /* ...Close the scanner to free resources */

        /* Perform calculations and output it */
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            char bit = binary.charAt(i);
            if (bit != '0' && bit != '1') {
                System.out.println("Hey! Illegal input! Only give (1 OR 0)'s");
                System.exit(0);
            }
            decimal = decimal * 2 + (bit - '0');
        }
        System.out.printf("Binary %s equals %d%n", binary, decimal);
    }
}

