
import java.util.Scanner;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Merging {

    static Node merge(Node first, Node second) {

        // Create dummy node
        Node dummy = new Node(0);

        Node tail = dummy;

        // Compare and attach smaller nodes
        while (first != null && second != null) {

            if (first.data <= second.data) {

                tail.next = first;
                first = first.next;

            } else {

                tail.next = second;
                second = second.next;
            }

            tail = tail.next;
        }

        // Attach remaining nodes
        if (first != null) {
            tail.next = first;
        } else {
            tail.next = second;
        }

        return dummy.next;
    }

    // Display linked list
    static void display(Node head) {

        Node current = head;

        while (current != null) {

            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Create linked list from input
    static Node createList(Scanner sc, int n) {

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // First linked list
        int n1 = sc.nextInt();
        Node first = createList(sc, n1);

        // Second linked list
        int n2 = sc.nextInt();
        Node second = createList(sc, n2);

        // Merge both lists
        Node result = merge(first, second);

        // Display merged list
        display(result);

        sc.close();
    }
}
