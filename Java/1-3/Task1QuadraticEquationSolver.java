
import java.util.Scanner;

public class Task1QuadraticEquationSolver {
    public static void main(String[] args) {
        /* Declare the scanner */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the quadratic equation solver!");
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("Please give the a");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("Please give the b");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println("Please give the c");
        double c = Double.parseDouble(scanner.nextLine());
        
        scanner.close(); /* ...Close the scanner to free resources */

        /* Perform calculations and output it */
        double discriminant = b * b - 4 * a * c;

        double sqrtD = Math.sqrt(discriminant);
        double root1 = (-b + sqrtD) / (2 * a);
        double root2 = (-b - sqrtD) / (2 * a);
        System.out.printf("Roots are %.1f and %.1f%n", root1, root2);
        
    }
}

