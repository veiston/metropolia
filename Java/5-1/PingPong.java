public class PingPong extends Thread {
    private String word;    // what word to print
    private int    delay;   // how long to pause

    public PingPong(String whatToSay, int delayTime) {
        word = whatToSay;
        delay = delayTime;
    }

    public void run() {
        try {
            while (true) {
                System.out.print(word + " ");
                Thread.sleep(delay);    // wait until next time
            }
        } catch (InterruptedException e) {
            return;                     // end this thread
        }
    }

    public static void main(String[] args) {
        new PingPong("ping", 3).start();   // 1/300 second
        new PingPong("PONG", 10).start();  // 1/100 second
    }
}