
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CountNodes {

    static int countNodes(Node head) {

        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public static void main(String[] args) {

        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);

        System.out.println("Total Nodes: " + countNodes(head));

        // Testing empty list
        Node emptyHead = null;

        System.out.println("Empty List Nodes: " +
                           countNodes(emptyHead));
    }
}
