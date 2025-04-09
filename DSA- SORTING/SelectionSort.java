class SelectionSort {
    public static void sortExamScores(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void printArray(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] examScores = {85, 90, 75, 60, 80};
        printArray(examScores);
        sortExamScores(examScores);
        printArray(examScores);
    }
}
