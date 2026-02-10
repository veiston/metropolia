import java.util.Random;

public class Task2NumSummary {
    public static void main(String[] args) throws InterruptedException {
        /* Taulukko satunnaisilla luvuilla */
        int size = 100000;
        int[] nums = new int[size];
        Random rnd = new Random();

        for (int i = 0; i < size; i++) {
            nums[i] = rnd.nextInt(1000);
        }

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Ytimiä: " + cores);

        SumWorker[] workers = new SumWorker[cores];
        Thread[] threads = new Thread[cores];

        int part = size / cores;
        int start = 0;

        for (int i = 0; i < cores; i++) {
            int end = start + part;
            if (i == cores - 1) {
                end = size;
            }

            workers[i] = new SumWorker(nums, start, end);
            threads[i] = new Thread(workers[i]);
            threads[i].start();

            start = end;
        }

        long sum = 0;
        for (int i = 0; i < cores; i++) {
            threads[i].join();
            sum += workers[i].getSum();
        }

        System.out.println("Summa: " + sum);
    }
}

class SumWorker implements Runnable {
    private final int[] nums;
    private final int start;
    private final int end;
    private long sum;

    public SumWorker(int[] nums, int start, int end) {
        this.nums = nums;
        this.start = start;
        this.end = end;
        this.sum = 0;
    }

    public void run() {
        long partSum = 0;
        for (int i = start; i < end; i++) {
            partSum += nums[i];
        }
        sum = partSum;
    }

    public long getSum() {
        return sum;
    }
}
