import java.util.Scanner;

public class Task3ObsoleteMeasures {

    public static void main(String[] args) {
        /* Declare the variables */
        double luoti = 13.28;
        double naula = luoti * 32;
        double leiviskä = naula * 20;

        /* Declare the scanner */
        Scanner scanner = new Scanner(System.in);

        /* Take the input and calculate into obsolete measurements */
        System.out.println("Input weight in grams: ");
        double inputWeight = Double.parseDouble(scanner.nextLine());
        int leiviskät = (int) (inputWeight / leiviskä);
        double remainder = inputWeight - leiviskät * leiviskä;
        int naulat = (int) (remainder / naula);
        remainder = remainder - naulat * naula;
        double luodit = remainder / luoti;

        System.out.printf(
            "%.0f grams is %d leiviskää, %d naulaa, and %.2f luotia.%n",
            inputWeight,
            leiviskät,
            naulat,
            luodit);

        /* Close the scanner */
        scanner.close();
    }

}