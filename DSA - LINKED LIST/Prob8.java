import java.util.*;

class TextState {
    String text;
    TextState next;
    TextState prev;

    TextState(String text) {
        this.text = text;
        this.next = null;
        this.prev = null;
    }
}

class Prob8 {
    TextState head;
    TextState tail;
    TextState currentState;
    int maxHistorySize;
    int historyCount;

    public Prob8(int maxHistorySize) {
        this.head = null;
        this.tail = null;
        this.currentState = null;
        this.maxHistorySize = maxHistorySize;
        this.historyCount = 0;
    }

    public void addTextState(String text) {
        TextState newState = new TextState(text);

        if (historyCount == maxHistorySize) {
            removeOldestState();
        }

        if (head == null) {
            head = newState;
            tail = newState;
            currentState = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            currentState = newState;
        }

        historyCount++;
    }

    private void removeOldestState() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            historyCount--;
        }
    }

    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.text);
        } else {
            System.out.println("No more undo history.");
        }
    }

    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.text);
        } else {
            System.out.println("No more redo history.");
        }
    }

    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current State: " + currentState.text);
        } else {
            System.out.println("No text state available.");
        }
    }

    public static void main(String[] args) {
        Prob8 editor = new Prob8(10);

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add Text\n2. Undo\n3. Redo\n4. Display Current State\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = sc.nextLine();
                    editor.addTextState(text);
                    editor.displayCurrentState();
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 5);

        sc.close();
    }
}
