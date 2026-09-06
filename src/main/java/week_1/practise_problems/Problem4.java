import java.util.Scanner;
class NonRepeating {
    char findFirstNonRepeatingChar(String text) {
        for (int i = 0; i < text.length(); i++) {
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    count++;
                }
            }
            if (count == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }
}
public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NonRepeating n = new NonRepeating();
        System.out.print("Enter a word: ");
        String text = sc.nextLine();
        char result = n.findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        }
        else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
        sc.close();
    }
}