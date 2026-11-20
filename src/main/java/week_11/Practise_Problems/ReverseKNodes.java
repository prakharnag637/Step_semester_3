
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseKNodes {

    static Node reverseFirstKNodes(Node head, int k) {

        Node prev = null;
        Node current = head;
        Node next = null;

        for (int i = 0; i < k; i++) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head.next = current;

        return prev;
    }

    static void display(Node head) {

        Node current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Original List: ");
        display(head);

        head = reverseFirstKNodes(head, 3);

        System.out.print("After Reversal: ");
        display(head);

        // Testing reversal of entire list
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);

        head2 = reverseFirstKNodes(head2, 5);

        System.out.print("Reverse Entire List: ");
        display(head2);
    }
}
