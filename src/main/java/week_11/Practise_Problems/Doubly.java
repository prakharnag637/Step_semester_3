
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

public class Doubly {

    static DNode insertAtTailDoubly(DNode head, int value) {

        DNode newNode = new DNode(value);

        if (head == null) {
            return newNode;
        }

        DNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;

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

        DNode head = new DNode(1);
        DNode second = new DNode(2);
        DNode third = new DNode(3);

        head.next = second;
        second.prev = head;

        second.next = third;
        third.prev = second;

        head = insertAtTailDoubly(head, 4);

        display(head);

        DNode emptyHead = null;
        emptyHead = insertAtTailDoubly(emptyHead, 7);

        display(emptyHead);
    }
}
