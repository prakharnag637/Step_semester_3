import java.util.Scanner;
class Customer {
    String reverseCustomerName(String customerName) {
        char[] arr = customerName.toCharArray();
        String reverse = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            reverse = reverse + arr[i];
        }
        return reverse;
    }
}
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer c = new Customer();
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();
        String reverse = c.reverseCustomerName(customerName);
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reverse);
        sc.close();
    }
}