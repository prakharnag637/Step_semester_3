
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveNodes {

    static Node removeFirstKNodes(Node head, int k) {

        if (head == null || k == 0) {
            return head;
        }

        for (int i = 0; i < k; i++) {

            if (head == null) {
                break;
            }

            head = head.next;
        }

        return head;
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

        head = removeFirstKNodes(head, 2);

        System.out.print("After Removing: ");
        display(head);

        // Test case: Remove all nodes
        Node head2 = new Node(1);
        head2.next = new Node(2);

        head2 = removeFirstKNodes(head2, 5);

        System.out.print("After Removing All: ");
        display(head2);
    }
}
