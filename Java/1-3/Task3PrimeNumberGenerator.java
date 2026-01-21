
import java.util.Scanner;

public class Task3PrimeNumberGenerator {
    public static void main(String[] args) {
        /* Declare the scanner */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give the start");
        int start = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Please give the end");
        int end = Integer.parseInt(scanner.nextLine().trim());
        
        scanner.close(); /* ...Close the scanner to free resources */

        /* Perform calculations and output it */
        if (start <= 0 || end <= 0) {
            System.out.println("Please provide positive integers.");
            return;
        }

        if (start >= end) {
            System.out.println("Start must be less than end.");
            return;
        }

        System.out.printf("Prime numbers between %d and %d:%n", start, end);
        boolean printed = false;

        for (int n = Math.max(2, start); n <= end; n++) {
            boolean prime = true;
            for (int d = 2; d * d <= n; d++) {
                if (n % d == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                System.out.println(n);
                printed = true;
            }
        }

        if (!printed) {
            System.out.println("(none)");
        }
    }
}

