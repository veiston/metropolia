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

        double leiviskät = Math.floor(inputWeight / leiviskä * 100) / 100;
        double naulat = Math.floor(inputWeight / naula * 100) / 100;
        double luodit = Math.floor(inputWeight / luoti * 100) / 100;

        System.out.println(inputWeight + "g equals to:\n" + 
        leiviskät + " leiviskää \n" + 
        naulat + " naulaa \n" + 
        luodit + " luotia");

        /* Close the scanner */
        scanner.close();
    }

}