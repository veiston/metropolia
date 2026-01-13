public class task2
 {
    public static void main(String[] args) {
        String asterisk = "*";
        String space = " ";
        for (int i = 1; i<8; i += 2) {
            String space1 = space.repeat((4-i/2));
            String obelix = asterisk.repeat(i);
            System.out.println(space1 + obelix);
        }
    }
}

