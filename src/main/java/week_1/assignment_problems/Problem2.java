class TypingChecker {
    void checkTypingAccuracy(String original, String typed) {
        int count = 0;
        int firstMismatch = -1;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                count++;
            }
            else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }
        double accuracy = ((double) count / original.length()) * 100;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                count, original.length(), accuracy);

        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        }
        else {
            System.out.println(" | First Mismatch at position "
                    + (firstMismatch + 1)
                    + " ('" + original.charAt(firstMismatch)
                    + "' vs '" + typed.charAt(firstMismatch) + "')");
        }
    }
}
public class Problem2 {
    public static void main(String[] args) {
        TypingChecker t = new TypingChecker();
        String original = "hello world";
        String typed = "hello worlt";
        t.checkTypingAccuracy(original, typed);
    }
}