
import java.util.Scanner;

class Node {

    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Counselling {

    // Partition linked list
    static Node partition(Node head, int passMark) {

        Node belowHead = null;
        Node belowTail = null;

        Node remainingHead = null;
        Node remainingTail = null;

        Node current = head;

        while (current != null) {

            // Save next node before changing links
            Node nextNode = current.next;

            // Disconnect current node
            current.next = null;

            // Group 1: Marks below pass mark
            if (current.data < passMark) {

                if (belowHead == null) {
                    belowHead = current;
                    belowTail = current;
                } else {
                    belowTail.next = current;
                    belowTail = current;
                }
            }

            // Group 2: Marks equal to or above pass mark
            else {

                if (remainingHead == null) {
                    remainingHead = current;
                    remainingTail = current;
                } else {
                    remainingTail.next = current;
                    remainingTail = current;
                }
            }

            current = nextNode;
        }

        // Connect both groups
        if (belowHead == null) {
            return remainingHead;
        }

        belowTail.next = remainingHead;

        return belowHead;
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

    // Create linked list
    static Node createList(Scanner sc, int n) {

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {

            int marks = sc.nextInt();

            Node newNode = new Node(marks);

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

        int n = sc.nextInt();

        Node head = createList(sc, n);

        int passMark = sc.nextInt();

        // Partition the linked list
        head = partition(head, passMark);

        // Display result
        display(head);

        sc.close();
    }
}
