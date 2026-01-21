import java.util.Scanner;

public class Task4MultiplicationTableExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int score = 0;

            for (int i = 1; i <= 10; i++) {
                int a = (int) (Math.random() * 10) + 1;
                int b = (int) (Math.random() * 10) + 1;

                System.out.printf("%d) %d x %d = ", i, a, b);
                int answer = Integer.parseInt(scanner.nextLine().trim());

                if (answer == a * b) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.printf("Shoot! That's incorrect. The correct answer is %d.%n", a * b);
                }
            }

            if (score == 10) {
                System.out.println("Congratulations! You won!");
                break;
            }

            System.out.printf("You scored %d/10. Let's try again!%n", score);
        }

        scanner.close();
    }
}
