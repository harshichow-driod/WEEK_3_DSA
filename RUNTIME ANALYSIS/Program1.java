import java.util.Arrays;

public class Program1 {
    
    public static void main(String[] args) {
        int[] smallDataset = new int[1000];
        int[] mediumDataset = new int[10000];
        int[] largeDataset = new int[1000000];
        
        for (int i = 0; i < smallDataset.length; i++) {
            smallDataset[i] = i + 1;
        }
        for (int i = 0; i < mediumDataset.length; i++) {
            mediumDataset[i] = i + 1;
        }
        for (int i = 0; i < largeDataset.length; i++) {
            largeDataset[i] = i + 1;
        }
        
        int target = 500;
        
        System.out.println("Linear Search - Small Dataset: " + linearSearch(smallDataset, target) + "ms");
        System.out.println("Binary Search - Small Dataset: " + binarySearch(smallDataset, target) + "ms");
        
        System.out.println("Linear Search - Medium Dataset: " + linearSearch(mediumDataset, target) + "ms");
        System.out.println("Binary Search - Medium Dataset: " + binarySearch(mediumDataset, target) + "ms");
        
        System.out.println("Linear Search - Large Dataset: " + linearSearch(largeDataset, target) + "ms");
        System.out.println("Binary Search - Large Dataset: " + binarySearch(largeDataset, target) + "ms");
    }
    
    public static long linearSearch(int[] dataset, int target) {
        long startTime = System.nanoTime();
        for (int i = 0; i < dataset.length; i++) {
            if (dataset[i] == target) {
                break;
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }
    
    public static long binarySearch(int[] dataset, int target) {
        long startTime = System.nanoTime();
        Arrays.sort(dataset);
        int left = 0;
        int right = dataset.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dataset[mid] == target) {
                break;
            }
            if (dataset[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }
}
