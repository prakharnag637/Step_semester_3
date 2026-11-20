
import java.util.Scanner;

class Node {

    String data;
    Node next;

    // Constructor
    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Announcement {

    static String kthFromEnd(Node head, int k) {

        Node lead = head;
        Node trail = head;

        for (int i = 0; i < k; i++) {

            if (lead == null) {
                return "Invalid k";
            }

            lead = lead.next;
        }

        while (lead != null) {

            lead = lead.next;
            trail = trail.next;
        }

        return trail.data;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {

            String id = sc.next();

            Node newNode = new Node(id);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int k = sc.nextInt();

        String result = kthFromEnd(head, k);

        if (result.equals("Invalid k")) {
            System.out.println("Invalid k");
        } else {
            System.out.println(k + " from the end: " + result);
        }

        sc.close();
    }
}
