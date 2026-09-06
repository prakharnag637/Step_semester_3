import java.util.Scanner;
class Palindrome {
    boolean isPalindromeIterative(String text) {
        int i = 0;
        int j = text.length() - 1;
        while (i < j) {
            if (text.charAt(i) != text.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }
    boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        String reverse = new String(arr);
        return text.equals(reverse);
    }
}
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Palindrome p = new Palindrome();
        System.out.print("Enter a word: ");
        String text = sc.nextLine();
        boolean a = p.isPalindromeIterative(text);
        boolean b = p.isPalindromeRecursive(text);
        boolean c = p.isPalindromeArrayReversal(text);
        System.out.println("Iterative: " +
                (a ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " +
                (b ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal: " +
                (c ? "Palindrome" : "Not Palindrome"));
        sc.close();
    }
}