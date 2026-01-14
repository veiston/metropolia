import java.util.Scanner;


public class Task2Triangles {
    public static void main(String[] args) {
        /* Declare the scanner */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the 🔺triangle🔺 hypotenuse calculator.");
        System.out.println("Please enter the first side of a triangle");
        /* Read the line */
        double input1 = Double.parseDouble(scanner.nextLine());

        System.out.println("Please enter the second side of a triangle");
        double input2 = Double.parseDouble(scanner.nextLine());
         /* Read the line */

        scanner.close(); /* ...Close the scanners to free resources */

        /* Perform hypotenuse calculation and output it */
        double hypotenuse = Math.sqrt(input1 * input1 + input2 * input2);
        /*ROUNDING! The "100" sets the rounding accuracy. */
        double truncated = Math.floor(hypotenuse * 100) / 100; 
        System.out.println("The hypotenuse is: " + truncated);
        
    }
}

