import java.util.Arrays;

public class Program16 {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;

        System.out.println("First Missing Positive: " + findFirstMissingPositive(arr));
        System.out.println("Index of Target: " + binarySearch(arr, target));
    }

    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (num <= n && arr[num - 1] > 0) {
                arr[num - 1] = -arr[num - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}


