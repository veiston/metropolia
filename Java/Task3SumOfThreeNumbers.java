
import java.util.Scanner;

public class Task3SumOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* Changed the variable dataatypes to Double */
        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        double third = Double.parseDouble(scanner.nextLine());

        System.out.println("The sum of the numbers is " + (first + second + third));
        /* calculate product of numbers */
        System.out.println("The product of the numbers is " + (first * second * third));
        /* calculate average of numbers */
        System.out.println("The average of the numbers is " + ((first + second + third)/3));
    }
}
