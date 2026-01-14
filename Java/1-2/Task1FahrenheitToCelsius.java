
import java.util.Scanner;

public class Task1FahrenheitToCelsius {
    public static void main(String[] args) {
        /* Declare the scanner */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a temperature in Fahrenheit");

        /* Read the line */
        double input = Double.parseDouble(scanner.nextLine());
        scanner.close(); /* ...Close the scanner to free resources */

        /* Perform conversion and output it */
        double conversion = (input - 32) / 1.8;
        System.out.println(conversion);
        
    }
}

