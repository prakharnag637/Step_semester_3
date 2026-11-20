
import java.util.Scanner;

class Participant {

    String name;
    int score;

    
    Participant(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class Leaderboard {

    static void insertionSort(Participant[] participants) {

        for (int i = 1; i < participants.length; i++) {

            Participant key = participants[i];

            int j = i - 1;

            // Shift participants with strictly lower scores
            while (j >= 0 && participants[j].score < key.score) {

                participants[j + 1] = participants[j];
                j--;
            }

            participants[j + 1] = key;
        }
    }

    // Print competition rankings
    static void printRanks(Participant[] participants) {

        int rank = 1;

        for (int i = 0; i < participants.length; i++) {

            // Equal scores retain the previous rank
            if (i > 0 &&
                participants[i].score != participants[i - 1].score) {

                rank = i + 1;
            }

            System.out.println(
                rank + " " +
                participants[i].name + " " +
                participants[i].score
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Participant[] participants = new Participant[n];

        // Read participant details
        for (int i = 0; i < n; i++) {

            String name = sc.next();
            int score = sc.nextInt();

            participants[i] = new Participant(name, score);
        }

        // Sort participants
        insertionSort(participants);

        // Display rankings
        printRanks(participants);

        sc.close();
    }
}
