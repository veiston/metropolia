package Java.Orientation3;

import java.util.Random;

public class Task2AgeDistribution {
    public static void main(String[] args) {
        /* Ikäjakaumat */
        int[] ages = {19, 20, 21, 22, 23, 24, 42, 69};
        int[] amount = {5, 12, 20, 18, 9, 6, 1, 1};

        /* Laske keskiarvo */
        double mean = computeMean(ages, amount);
        double std = computeStdDev(ages, amount, mean);
        int draws = 1000;

        /* Eri seedien arvot */
        long[] seeds = {1234L, 9876L, System.currentTimeMillis()};

        for (int run = 0; run < seeds.length; run++) {
            Random rng = new Random(seeds[run]);
            int[] results = new int[ages.length];

            for (int i = 0; i < draws; i++) {
                int index = drawIndexNormal(rng, mean, std, ages);
                results[index]++;
            }

            System.out.println("Run " + (run + 1) + " (seed=" + seeds[run] + ")");
            printResults(ages, results, draws);
            System.out.println();
        }
    }

    private static double computeMean(int[] ages, int[] amount) {
        int total = 0;
        int sum = 0;
        for (int i = 0; i < ages.length; i++) {
            sum += ages[i] * amount[i];
            total += amount[i];
        }
        return (double) sum / total;
    }

    private static double computeStdDev(int[] ages, int[] amount, double mean) {
        int total = 0;
        double sum = 0.0;
        for (int i = 0; i < ages.length; i++) {
            double diff = ages[i] - mean;
            sum += diff * diff * amount[i];
            total += amount[i];
        }
        return Math.sqrt(sum / total);
    }

    private static int drawIndexNormal(Random rng, double mean, double std, int[] ages) {
        double value = mean + std * rng.nextGaussian();
        int closest = 0;
        double best = Math.abs(value - ages[0]);
        for (int i = 1; i < ages.length; i++) {
            double dist = Math.abs(value - ages[i]);
            if (dist < best) {
                best = dist;
                closest = i;
            }
        }
        return closest;
    }

    private static void printResults(int[] ages, int[] results, int draws) {
        for (int i = 0; i < ages.length; i++) {
            double pct = (results[i] * 100.0) / draws;
            System.out.printf("Age %d: %d (%.1f%%)%n", ages[i], results[i], pct);
        }
    }
}
