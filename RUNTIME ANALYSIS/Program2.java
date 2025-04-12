import java.util.Arrays;

public class Program2 {

    public static void main(String[] args) {
        int[] smallDataset = new int[1000];
        int[] mediumDataset = new int[10000];
        int[] largeDataset = new int[1000000];

        for (int i = 0; i < smallDataset.length; i++) {
            smallDataset[i] = (int) (Math.random() * 1000);
        }
        for (int i = 0; i < mediumDataset.length; i++) {
            mediumDataset[i] = (int) (Math.random() * 10000);
        }
        for (int i = 0; i < largeDataset.length; i++) {
            largeDataset[i] = (int) (Math.random() * 1000000);
        }

        System.out.println("Bubble Sort - Small Dataset: " + bubbleSort(Arrays.copyOf(smallDataset, smallDataset.length)) + "ms");
        System.out.println("Merge Sort - Small Dataset: " + mergeSort(Arrays.copyOf(smallDataset, smallDataset.length)) + "ms");
        System.out.println("Quick Sort - Small Dataset: " + quickSort(Arrays.copyOf(smallDataset, smallDataset.length)) + "ms");

        System.out.println("Bubble Sort - Medium Dataset: " + bubbleSort(Arrays.copyOf(mediumDataset, mediumDataset.length)) + "ms");
        System.out.println("Merge Sort - Medium Dataset: " + mergeSort(Arrays.copyOf(mediumDataset, mediumDataset.length)) + "ms");
        System.out.println("Quick Sort - Medium Dataset: " + quickSort(Arrays.copyOf(mediumDataset, mediumDataset.length)) + "ms");

        System.out.println("Bubble Sort - Large Dataset: " + bubbleSort(Arrays.copyOf(largeDataset, largeDataset.length)) + "ms");
        System.out.println("Merge Sort - Large Dataset: " + mergeSort(Arrays.copyOf(largeDataset, largeDataset.length)) + "ms");
        System.out.println("Quick Sort - Large Dataset: " + quickSort(Arrays.copyOf(largeDataset, largeDataset.length)) + "ms");
    }

    public static long bubbleSort(int[] dataset) {
        long startTime = System.nanoTime();
        for (int i = 0; i < dataset.length - 1; i++) {
            for (int j = 0; j < dataset.length - 1 - i; j++) {
                if (dataset[j] > dataset[j + 1]) {
                    int temp = dataset[j];
                    dataset[j] = dataset[j + 1];
                    dataset[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    public static long mergeSort(int[] dataset) {
        long startTime = System.nanoTime();
        mergeSortHelper(dataset, 0, dataset.length - 1);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    private static void mergeSortHelper(int[] dataset, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(dataset, left, mid);
            mergeSortHelper(dataset, mid + 1, right);
            merge(dataset, left, mid, right);
        }
    }

    private static void merge(int[] dataset, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        System.arraycopy(dataset, left, leftArray, 0, n1);
        System.arraycopy(dataset, mid + 1, rightArray, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                dataset[k] = leftArray[i];
                i++;
            } else {
                dataset[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            dataset[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            dataset[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static long quickSort(int[] dataset) {
        long startTime = System.nanoTime();
        quickSortHelper(dataset, 0, dataset.length - 1);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    private static void quickSortHelper(int[] dataset, int low, int high) {
        if (low < high) {
            int pi = partition(dataset, low, high);
            quickSortHelper(dataset, low, pi - 1);
            quickSortHelper(dataset, pi + 1, high);
        }
    }

    private static int partition(int[] dataset, int low, int high) {
        int pivot = dataset[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (dataset[j] <= pivot) {
                i++;
                int temp = dataset[i];
                dataset[i] = dataset[j];
                dataset[j] = temp;
            }
        }
        int temp = dataset[i + 1];
        dataset[i + 1] = dataset[high];
        dataset[high] = temp;
        return i + 1;
    }
}
