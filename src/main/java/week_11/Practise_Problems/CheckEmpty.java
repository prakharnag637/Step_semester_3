
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CheckEmpty {

    static boolean checkIfEmpty(Node head) {

        return head == null;
    }

    public static void main(String[] args) {

        // Empty linked list
        Node head1 = null;

        // Non-empty linked list
        Node head2 = new Node(8);

        System.out.println("List 1 Empty: " +
                           checkIfEmpty(head1));

        System.out.println("List 2 Empty: " +
                           checkIfEmpty(head2));
    }
}
