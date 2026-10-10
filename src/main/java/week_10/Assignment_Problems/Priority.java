import java.util.*;
public class Priority {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node head;
    static void addFirst(int token) {
        Node newNode = new Node(token);
        newNode.next = head;
        head = newNode;
    }
    static void addLast(int token) {
        Node newNode = new Node(token);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    static void insertAt(int index, int token) {
        if (index == 0) {
            addFirst(token);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(token);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            addLast(sc.nextInt());
        }
        int operations = sc.nextInt();
        for (int i = 0; i < operations; i++) {
            String operation = sc.next();
            switch (operation) {
                case "addFirst":
                    addFirst(sc.nextInt());
                    break;
                case "addLast":
                    addLast(sc.nextInt());
                    break;
                case "insertAt":
                    int index = sc.nextInt();
                    int token = sc.nextInt();
                    insertAt(index, token);
                    break;
            }
        }
        display();
        sc.close();
    }
}