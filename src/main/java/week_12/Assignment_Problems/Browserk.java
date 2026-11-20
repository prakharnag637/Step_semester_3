
import java.util.Scanner;

class Node {

    String name;
    Node prev;
    Node next;

    // Constructor
    Node(String name) {
        this.name = name;
        this.prev = null;
        this.next = null;
    }
}

class Browser {

    Node head;
    Node current;

    // Open a new tab after the current tab
    void open(String name) {

        Node newTab = new Node(name);

        if (current == null) {
            head = newTab;
            current = newTab;
        } else {

            newTab.prev = current;
            newTab.next = current.next;

            if (current.next != null) {
                current.next.prev = newTab;
            }

            current.next = newTab;
            current = newTab;
        }

        System.out.print("OPEN " + name + ": ");
        display();
    }

    // Close the current tab
    void close() {

        if (current == null) {
            System.out.println("CLOSE: no tabs open");
            return;
        }

        String closedName = current.name;

        Node previous = current.prev;
        Node nextTab = current.next;

        if (previous != null) {
            previous.next = nextTab;
        } else {
            head = nextTab;
        }

        if (nextTab != null) {
            nextTab.prev = previous;
        }

        // Next tab becomes current, otherwise previous
        if (nextTab != null) {
            current = nextTab;
        } else {
            current = previous;
        }

        System.out.print("CLOSE " + closedName + ": ");
        display();
    }

    // Move to previous tab
    void back() {

        if (current == null || current.prev == null) {
            System.out.println("BACK: already at first tab");
            return;
        }

        current = current.prev;

        System.out.print("BACK: ");
        display();
    }

    // Move to next tab
    void forward() {

        if (current == null || current.next == null) {
            System.out.println("FORWARD: already at last tab");
            return;
        }

        current = current.next;

        System.out.print("FORWARD: ");
        display();
    }

    // Display tabs from first to last
    void display() {

        Node temp = head;

        while (temp != null) {

            if (temp == current) {
                System.out.print("[" + temp.name + "]");
            } else {
                System.out.print(temp.name);
            }

            if (temp.next != null) {
                System.out.print(" <-> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    // Print tabs from last to first
    void printBackward() {

        if (head == null) {
            System.out.println("Backward: (empty)");
            return;
        }

        Node temp = head;

        // Reach the last tab
        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.print("Backward: ");

        // Traverse backwards
        while (temp != null) {

            System.out.print(temp.name);

            if (temp.prev != null) {
                System.out.print(" <-> ");
            }

            temp = temp.prev;
        }

        System.out.println();
    }
}

public class Browserk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Browser browser = new Browser();

        // Read commands
        StringBuilder input = new StringBuilder();

        while (sc.hasNextLine()) {
            input.append(sc.nextLine()).append(" ");
        }

        // Split commands using comma
        String[] commands = input.toString().split(",");

        for (String command : commands) {

            command = command.trim();

            if (command.startsWith("OPEN ")) {

                String name = command.substring(5).trim();
                browser.open(name);

            } else if (command.equals("CLOSE")) {

                browser.close();

            } else if (command.equals("BACK")) {

                browser.back();

            } else if (command.equals("FORWARD")) {

                browser.forward();

            } else if (command.equals("PRINT BACKWARD")) {

                browser.printBackward();
            }
        }

        sc.close();
    }
}
