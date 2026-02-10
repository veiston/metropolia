import java.util.Scanner;

public class Task1NumPrint {
    public static void main(String[] args) throws InterruptedException {
        /* Lue aloitus-ja lopetus */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Aloitusluku?:");
        int start = Integer.parseInt(scanner.nextLine());

        System.out.println("Lopetusluku:");
        int end = Integer.parseInt(scanner.nextLine());
        scanner.close();

        /* 2 säiettä */
        PrintState st = new PrintState(start, end);

        Thread t1 = new Thread(new OddPrinter(st));
        Thread t2 = new Thread(new EvenPrinter(st));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Haha! Valmista tuli!");
    }
}

class PrintState {
    public int current;
    public int end;
    public boolean oddTurn;
    public final Object lock = new Object();

    public PrintState(int start, int end) {
        this.current = start;
        this.end = end;
        this.oddTurn = (start % 2 != 0);
    }
}

class OddPrinter implements Runnable {
    private final PrintState st;

    public OddPrinter(PrintState st) {
        this.st = st;
    }

    public void run() {
        while (true) {
            synchronized (st.lock) {
                if (st.current > st.end) {
                    break;
                }
                if (st.oddTurn && st.current % 2 != 0) {
                    System.out.println("Pariton: " + st.current);
                    st.current++;
                    st.oddTurn = false;
                }
            }
            Thread.yield();
        }
    }
}

class EvenPrinter implements Runnable {
    private final PrintState st;

    public EvenPrinter(PrintState st) {
        this.st = st;
    }

    public void run() {
        while (true) {
            synchronized (st.lock) {
                if (st.current > st.end) {
                    break;
                }
                if (!st.oddTurn && st.current % 2 == 0) {
                    System.out.println("Parillinen: " + st.current);
                    st.current++;
                    st.oddTurn = true;
                }
            }
            Thread.yield();
        }
    }
}
