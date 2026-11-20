
import java.util.Scanner;

class Editor {

    String[] history;
    int top;
    int capacity;

    // Constructor
    Editor(int n) {
        capacity = n;
        history = new String[n];
        top = -1;
    }

    // TYPE operation
    void type(String word) {

        if (top == capacity - 1) {
            System.out.println("rejected: history full");
            return;
        }

        top++;
        history[top] = word;

        display();
    }

    // UNDO operation
    void undo() {

        if (top == -1) {
            System.out.println("rejected: nothing to undo");
            return;
        }

        history[top] = null;
        top--;

        display();
    }

    // Display current history
    void display() {

        if (top == -1) {
            System.out.println("(empty)");
            return;
        }

        for (int i = 0; i <= top; i++) {

            System.out.print(history[i]);

            if (i < top) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}

public class Undo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Editor editor = new Editor(n);

        sc.nextLine();

        while (sc.hasNextLine()) {

            String command = sc.nextLine().trim();

            if (command.isEmpty()) {
                continue;
            }

            // Support multiple commands separated by semicolons
            String[] commands = command.split(";");

            for (String cmd : commands) {

                cmd = cmd.trim();

                if (cmd.startsWith("TYPE ")) {

                    String word = cmd.substring(5).trim();
                    editor.type(word);

                } else if (cmd.equals("UNDO")) {

                    editor.undo();
                }
            }
        }

        sc.close();
    }
}
