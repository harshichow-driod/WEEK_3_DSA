import java.util.*;

class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class task3 {
    Task head = null;
    Task tail = null;
    Task current = null;

    void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            newTask.next = head;
            tail.next = newTask;
            head = newTask;
        }
    }

    void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            tail.next = newTask;
            newTask.next = head;
            tail = newTask;
        }
    }

    void addAtPosition(int position, int id, String name, int priority, String dueDate) {
        if (position == 0) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }
        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        for (int i = 0; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask;
        }
    }

    void removeById(int id) {
        if (head == null) return;
        Task temp = head, prev = null;
        do {
            if (temp.id == id) {
                if (temp == head) {
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else {
                    prev.next = temp.next;
                    if (temp == tail) tail = prev;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void viewCurrentTask() {
        if (current == null) {
            current = head;
        }
        if (current != null) {
            System.out.println("Current Task -> ID: " + current.id + ", Name: " + current.name + ", Priority: " + current.priority + ", Due: " + current.dueDate);
            current = current.next;
        } else {
            System.out.println("No tasks in the list.");
        }
    }

    void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found -> ID: " + temp.id + ", Name: " + temp.name + ", Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No task found with given priority.");
        }
    }

    public static void main(String[] args) {
        task3 scheduler = new task3();

        scheduler.addAtBeginning(1, "Design", 2, "2025-04-20");
        scheduler.addAtEnd(2, "Development", 1, "2025-04-25");
        scheduler.addAtPosition(1, 3, "Testing", 3, "2025-04-22");

        System.out.println("All Tasks:");
        scheduler.displayTasks();

        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        System.out.println("\nSearch by Priority 1:");
        scheduler.searchByPriority(1);

        scheduler.removeById(2);
        System.out.println("\nAfter Removing Task with ID 2:");
        scheduler.displayTasks();
    }
}
