
import java.util.Scanner;

public class Notice {

    static String shiftNotice(String text, int k) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            // Lowercase letters
            if (ch >= 'a' && ch <= 'z') {

                char shifted = (char) ((ch - 'a' + k) % 26 + 'a');
                result.append(shifted);

            }

            // Uppercase letters
            else if (ch >= 'A' && ch <= 'Z') {

                char shifted = (char) ((ch - 'A' + k) % 26 + 'A');
                result.append(shifted);

            }

            // Keep other characters unchanged
            else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        int k = sc.nextInt();

        System.out.println(shiftNotice(text, k));

        sc.close();
    }
}
