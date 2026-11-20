
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertCircular {

    static Node insertAtEndCircular(Node head, int value) {

        Node newNode = new Node(value);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node current = head;

        while (current.next != head) {
            current = current.next;
        }

        current.next = newNode;
        newNode.next = head;

        return head;
    }

    static void display(Node head) {

        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data);
            current = current.next;

            if (current != head) {
                System.out.print(" -> ");
            }

        } while (current != head);

        System.out.println(" -> (back to " + head.data + ")");
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        head.next = second;
        second.next = third;
        third.next = head;

        System.out.print("Original List: ");
        display(head);

        head = insertAtEndCircular(head, 4);

        System.out.print("After Insertion: ");
        display(head);

        // Testing empty list
        Node emptyHead = null;
        emptyHead = insertAtEndCircular(emptyHead, 9);

        System.out.print("Empty List Insertion: ");
        display(emptyHead);
    }
}
