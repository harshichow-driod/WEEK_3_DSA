public class Program10 {
    public static void main(String[] args) {
        int[] arr = {3, 5, -2, 7, -1, 9};
        int result = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                result = i;
                break;
            }
        }
        
        System.out.println(result);
    }
}