import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {
    public static void main(String[] args) throws Exception {
        /* Kirjoitetaan 60 Fibonaccia CSVhen */
        int numbers = 60;
        Path file = Path.of("fibonacci.csv");

        long a = 0;
        long b = 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers; i++) {
            sb.append(i).append(": ").append(a).append('\n');
            long next = a + b;
            a = b;
            b = next;
        }

        Files.writeString(file, sb.toString(), StandardCharsets.UTF_8);
        System.out.println("Kirjoitettu " + numbers + " lukua fibonacci.csv");
    }
}
