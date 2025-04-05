import java.util.*;

class Item {
    String name;
    String id;
    int quantity;
    double price;
    Item next;

    Item(String name, String id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Prob4 {
    Item head;

    void addAtBeginning(String name, String id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    void addAtEnd(String name, String id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newItem;
    }

    void addAtPosition(int position, String name, String id, int quantity, double price) {
        if (position == 0) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item newItem = new Item(name, id, quantity, price);
        Item current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) return;
        newItem.next = current.next;
        current.next = newItem;
    }

    void removeById(String id) {
        if (head == null) return;
        if (head.id.equals(id)) {
            head = head.next;
            return;
        }
        Item current = head;
        while (current.next != null && !current.next.id.equals(id)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    void updateQuantity(String id, int newQuantity) {
        Item current = head;
        while (current != null) {
            if (current.id.equals(id)) {
                current.quantity = newQuantity;
                return;
            }
            current = current.next;
        }
    }

    Item searchById(String id) {
        Item current = head;
        while (current != null) {
            if (current.id.equals(id)) return current;
            current = current.next;
        }
        return null;
    }

    Item searchByName(String name) {
        Item current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) return current;
            current = current.next;
        }
        return null;
    }

    double calculateTotalValue() {
        double total = 0;
        Item current = head;
        while (current != null) {
            total += current.quantity * current.price;
            current = current.next;
        }
        return total;
    }

    void displayInventory() {
        Item current = head;
        while (current != null) {
            System.out.println("Name: " + current.name + ", ID: " + current.id + ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }

    void sortInventoryByName(boolean ascending) {
        head = mergeSort(head, ascending, true);
    }

    void sortInventoryByPrice(boolean ascending) {
        head = mergeSort(head, ascending, false);
    }

    Item mergeSort(Item head, boolean ascending, boolean sortByName) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item nextToMiddle = middle.next;
        middle.next = null;
        Item left = mergeSort(head, ascending, sortByName);
        Item right = mergeSort(nextToMiddle, ascending, sortByName);
        return merge(left, right, ascending, sortByName);
    }

    Item merge(Item left, Item right, boolean ascending, boolean sortByName) {
        if (left == null) return right;
        if (right == null) return left;
        Item result;
        int compare = sortByName ? left.name.compareToIgnoreCase(right.name) : Double.compare(left.price, right.price);
        if ((ascending && compare <= 0) || (!ascending && compare > 0)) {
            result = left;
            result.next = merge(left.next, right, ascending, sortByName);
        } else {
            result = right;
            result.next = merge(left, right.next, ascending, sortByName);
        }
        return result;
    }

    Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Prob4 inventory = new Prob4();

        inventory.addAtEnd("Pen", "P001", 100, 5.0);
        inventory.addAtBeginning("Notebook", "N001", 50, 20.0);
        inventory.addAtPosition(1, "Eraser", "E001", 75, 3.5);

        System.out.println("Initial Inventory:");
        inventory.displayInventory();

        inventory.updateQuantity("P001", 120);
        System.out.println("\nInventory after updating quantity:");
        inventory.displayInventory();

        Item item = inventory.searchById("N001");
        if (item != null) {
            System.out.println("\nItem found: " + item.name + " - " + item.quantity);
        }

        double totalValue = inventory.calculateTotalValue();
        System.out.println("\nTotal Inventory Value: " + totalValue);

        inventory.sortInventoryByName(true);
        System.out.println("\nInventory Sorted by Name (Ascending):");
        inventory.displayInventory();

        inventory.sortInventoryByPrice(false);
        System.out.println("\nInventory Sorted by Price (Descending):");
        inventory.displayInventory();
    }
}
