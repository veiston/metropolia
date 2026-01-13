public class Task2
 {
    public static void main(String[] args) {
        String asterisk = "*";
        String space = " ";

        /* Loop to draw the inverse pyramid */
        for (int i = 1; i<8; i += 2) {
            String space1 = space.repeat((4-i/2)); /* Initialize or adapt variable for spaces */
            String obelix = asterisk.repeat(i); /* Initialize or adapt variable for Asterisks*/
            System.out.println(space1 + obelix); /* Draw the lines */
        }
    }
}

