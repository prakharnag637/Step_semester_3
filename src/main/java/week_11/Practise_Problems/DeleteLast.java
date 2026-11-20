
class DNode {
    int data;
    DNode prev;
    DNode next;

    DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DeleteLast {

    static DNode deleteLastNodeDoubly(DNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        DNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.prev.next = null;
        current.prev = null;

        return head;
    }

    static void display(DNode head) {

        DNode current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" <-> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Creating a doubly linked list
        DNode head = new DNode(1);
        DNode second = new DNode(2);
        DNode third = new DNode(3);

        head.next = second;
        second.prev = head;

        second.next = third;
        third.prev = second;

        System.out.print("Original List: ");
        display(head);

        // Delete last node
        head = deleteLastNodeDoubly(head);

        System.out.print("After Deletion: ");
        display(head);

        // Testing single-node list
        DNode head2 = new DNode(5);
        head2 = deleteLastNodeDoubly(head2);

        System.out.print("Single Node List: ");
        display(head2);

        // Testing empty list
        DNode head3 = null;
        head3 = deleteLastNodeDoubly(head3);

        System.out.print("Empty List: ");
        display(head3);
    }
}
