import java.util.Scanner;

public class Task1NameGenerator {

    public static void main(String[] args) {
        String[] firstNames = {
            "Emma", "Veikka", "Aaro", "Leo", "Olivia",
            "Elias", "Sofia", "Elli", "Milla", "Jarkko"
        };

        String[] lastNames = {
            "Korhonen", "Liukkonen", "Mäkinen", "Nieminen", "Mäkelä",
            "Kuusinen", "Laine", "Kärpänen", "Vuori", "Järvinen"
        };

        /* Declare the scanner */
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many random names should I generate?");
        /* Read the line */
        int count = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 1; i <= count; i++) {
            int firstIndex = (int) (Math.random() * firstNames.length);
            int lastIndex = (int) (Math.random() * lastNames.length);
            System.out.println(firstNames[firstIndex] + " " + lastNames[lastIndex]);
        }

        scanner.close(); /* ...Close the scanner to free resources */
    }
}
