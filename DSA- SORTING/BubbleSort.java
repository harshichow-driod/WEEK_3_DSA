public class BubbleSort {
    
    public static void sortMarks(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    
    public static void printArray(int[] marks) {
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] studentMarks = {70, 85, 90, 60, 75};
        printArray(studentMarks);
        sortMarks(studentMarks);
        printArray(studentMarks);
    }
}
