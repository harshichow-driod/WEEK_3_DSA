import java.util.*;

public class Program6 {

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000};

        for (int n : datasetSizes) {
            System.out.println("Array Search - N=" + n + ": " + searchInArray(n) + "ms");
            System.out.println("HashSet Search - N=" + n + ": " + searchInHashSet(n) + "ms");
            System.out.println("TreeSet Search - N=" + n + ": " + searchInTreeSet(n) + "ms");
        }
    }

    public static long searchInArray(int n) {
        long startTime = System.nanoTime();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int target = n - 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                break;
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    public static long searchInHashSet(int n) {
        long startTime = System.nanoTime();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        set.contains(n - 1);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    public static long searchInTreeSet(int n) {
        long startTime = System.nanoTime();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        set.contains(n - 1);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }
}
