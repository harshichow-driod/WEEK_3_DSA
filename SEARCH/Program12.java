
public class Program12 {
    public static void main(String[] args) {
        int[] arr = {6, 7, 9, 15, 19, 2, 3};
        int left = 0, right = arr.length - 1;
        int rotationPoint = -1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        rotationPoint = left;
        System.out.println(rotationPoint);
    }
}


