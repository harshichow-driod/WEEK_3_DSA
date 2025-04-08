import java.util.*;

class Hash4 {
    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] table;
    private int size;

    public Hash4() {
        table = new Node[16];
        size = 0;
    }

    private int hash(int key) {
        return Math.abs(key) % table.length;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current.next != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int get(int key) {
        int index = hash(key);
        Node current = table[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node current = table[index];
        Node previous = null;
        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public boolean containsKey(int key) {
        int index = hash(key);
        Node current = table[index];
        while (current != null) {
            if (current.key == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        Hash4 map = new Hash4();
        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));
    }
}
