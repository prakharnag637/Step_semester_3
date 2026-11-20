
import java.util.Arrays;

public class NoticeBoard {

    static int[] bubbleStats(int[] scores) {

        int passes = 0;
        int swaps = 0;

        while (true) {

            boolean swapped = false;
            passes++;

            for (int i = 0; i < scores.length - 1; i++) {

                if (scores[i] > scores[i + 1]) {

                    int temp = scores[i];
                    scores[i] = scores[i + 1];
                    scores[i + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return new int[]{passes, swaps};
    }

    public static void main(String[] args) {

        int[] scores = {5, 1, 4, 2, 8};

        int[] result = bubbleStats(scores);

        System.out.println("Sorted Array: " +
                           Arrays.toString(scores));

        System.out.println("Passes: " + result[0]);
        System.out.println("Swaps: " + result[1]);

        // Already sorted array
        int[] scores2 = {1, 2, 3, 4};

        int[] result2 = bubbleStats(scores2);

        System.out.println("\nAlready Sorted Array: " +
                           Arrays.toString(scores2));

        System.out.println("Passes: " + result2[0]);
        System.out.println("Swaps: " + result2[1]);
    }
}
