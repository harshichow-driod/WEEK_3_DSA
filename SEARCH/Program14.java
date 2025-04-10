
public class Program14 {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };
        int target = 5;
        
        System.out.println(searchMatrix(matrix, target));
    }
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0, right = rows * columns - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / columns;
            int col = mid % columns;
            
            if (matrix[row][col] == target) {
                return true;
            }
            
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}
