class CountingSort {
    public static void sortStudentAges(int[] ages) {
        int maxAge = 18;
        int[] count = new int[maxAge + 1];
        for (int age : ages) {
            count[age]++;
        }
        int index = 0;
        for (int i = 10; i <= maxAge; i++) {
            while (count[i] > 0) {
                ages[index++] = i;
                count[i]--;
            }
        }
    }

    public static void printArray(int[] ages) {
        for (int i = 0; i < ages.length; i++) {
            System.out.print(ages[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] studentAges = {15, 12, 17, 14, 16};
        printArray(studentAges);
        sortStudentAges(studentAges);
        printArray(studentAges);
    }
}
