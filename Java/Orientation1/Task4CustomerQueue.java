import java.util.LinkedList;
import java.util.Scanner;

public class Task4CustomerQueue {
    public static void main(String[] args) {
        /* Create queue */
        LinkedList<Customer> queue = new LinkedList<>();

        /* Declare the scanner */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Customer Queue (1 = queue, 2 = leae queue, 3 = exit)");

        while (true) {
            System.out.print("Action: ");
            String action = scanner.nextLine().trim().toLowerCase();

            if (action.equals("x")) {
                System.out.println("Exit.");
                break;
            }

            if (action.equals("q")) {
                /* Add customer BOOM FIFO */
                Customer customer = new Customer();
                customer.setStartTime(System.nanoTime());
                queue.addFirst(customer);
                System.out.println("Queued customer id: " + customer.getId());
                continue;
            }

            if (action.equals("d")) {
                /* Remove customer) */
                if (queue.isEmpty()) {
                    System.out.println("Queue is empty.");
                    continue;
                }

                Customer customer = queue.removeLast();
                customer.setEndTime(System.nanoTime());
                System.out.println("Dequeued customer id: " + customer.getId());
                System.out.println("Time spent in queue: " + customer.getTimeSpent() + " ns");
                System.out.println("Time spent in queue: " + (customer.getTimeSpent() / 1_000_000_000.0) + " s");
                continue;
            }

            System.out.println("Unknown action. Use q, d, or x.");
        }

        scanner.close(); /* ...Close the scanner to free resources */
    }
}
