import java.util.Random;
import java.util.Scanner;

/**
 * JetBrains Academy task solution. Gaussian random numbers.
 * For the given numbers K, N, and M find the first seed that is greater or equal to K where
 * each of N Gaussian numbers is less than or equal to M.
 * The input contains numbers K, N, M in a single line.
 * You should output the seed.
 **/

public class GaussianTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String[] line = scanner.nextLine().split(" ");
            long K = Long.parseLong(line[0]);
            long N = Long.parseLong(line[1]);
            double M = Double.parseDouble(line[2]);
            long seed = K;
            Random random;
            boolean found = false;
            while (!found) {
                random = new Random(seed);
                for (int i = 1; i <= N; ) {
                    if (random.nextGaussian() <= M) {
                        if (i == N) {
                            found = true;
                        }
                        i++;
                    } else {
                        seed++;
                        break;
                    }
                }
            }
            System.out.println(seed);
        } catch (NumberFormatException nfe) {
            System.out.println("You must input numbers");
        }
    }
}


