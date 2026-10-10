import java.util.*;
public class Grid{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[100];
        int[][] marks = new int[100][3];
        int n = 0;
        while (sc.hasNext()) {
            names[n] = sc.next();
            sc.next(); // Skip '['
            for (int j = 0; j < 3; j++) {
                String value = sc.next();
                value = value.replace(",", "").replace("]", "");
                marks[n][j] = Integer.parseInt(value);
            }
            n++;
        }
        int[] totals = new int[n];
        int[] subjectTotals = new int[3];
        int topper = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                totals[i] += marks[i][j];
                subjectTotals[j] += marks[i][j];
            }
            if (totals[i] > totals[topper]) {
                topper = i;
            }
        }
        System.out.print("Totals ");
        for (int i = 0; i < n; i++) {
            System.out.print(names[i] + " " + totals[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("\naverages ");
        for (int j = 0; j < 3; j++) {
            double average = (double) subjectTotals[j] / n;
            System.out.printf("%.2f", average);
            if (j < 2) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("topper " + names[topper] + " (" + totals[topper] + ")");
        sc.close();
    }
}