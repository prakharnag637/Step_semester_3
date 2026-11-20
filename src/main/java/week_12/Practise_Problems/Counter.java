
import java.util.Scanner;

public class Counter {

    // Find the first index whose value is >= x
    static int lowerBound(int[] scores, int x) {

        int low = 0;
        int high = scores.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (scores[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Answer each query
    static void answerQuery(int[] scores, int x) {

        int below = lowerBound(scores, x);

        int exactly = lowerBound(scores, x + 1) - below;

        System.out.println(
            x + ": exactly " + exactly + ", below " + below
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of scores
        int n = sc.nextInt();

        int[] scores = new int[n];

        // Read sorted scores
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        // Read number of queries
        int q = sc.nextInt();

        // Process queries
        for (int i = 0; i < q; i++) {

            int x = sc.nextInt();

            answerQuery(scores, x);
        }

        sc.close();
    }
}
