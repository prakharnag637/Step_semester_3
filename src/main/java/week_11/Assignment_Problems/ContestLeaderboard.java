
class Entry {

    String name;
    int marks;

    Entry(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class ContestLeaderboard {

    static Entry[] leaderboard(Entry[] entries) {

        int n = entries.length;

        int[] count = new int[101];

        Entry[] output = new Entry[n];

        // Step 1: Count frequency
        for (int i = 0; i < n; i++) {

            int key = 100 - entries[i].marks;

            count[key]++;
        }

        // Step 2: Cumulative count
        for (int i = 1; i < 101; i++) {

            count[i] += count[i - 1];
        }

        // Step 3: Stable placement
        for (int i = n - 1; i >= 0; i--) {

            int key = 100 - entries[i].marks;

            output[--count[key]] = entries[i];
        }

        return output;
    }

    static void display(Entry[] entries) {

        for (int i = 0; i < entries.length; i++) {

            System.out.print(
                entries[i].name + " " + entries[i].marks
            );

            if (i < entries.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Entry[] entries = {
            new Entry("Asha", 90),
            new Entry("Ravi", 75),
            new Entry("Neha", 90),
            new Entry("Kiran", 100),
            new Entry("Meera", 75)
        };

        System.out.println("Original Leaderboard:");
        display(entries);

        Entry[] result = leaderboard(entries);

        System.out.println("\nSorted Leaderboard:");
        display(result);
    }
}
