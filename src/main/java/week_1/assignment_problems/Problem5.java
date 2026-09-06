import java.util.Scanner;
class WordProfiler {
    void classifyWordLengths(String review) {
        String[] words = review.split(" ");
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            if (length >= 1 && length <= 4) {
                shortWords++;
            }
            else if (length >= 5 && length <= 8) {
                mediumWords++;
            }
            else {
                longWords++;
            }
        }
        System.out.println("Short: " + shortWords);
        System.out.println("Medium: " + mediumWords);
        System.out.println("Long: " + longWords);
    }
}
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordProfiler w = new WordProfiler();
        System.out.print("Enter movie review: ");
        String review = sc.nextLine();
        w.classifyWordLengths(review);
        sc.close();
    }
}