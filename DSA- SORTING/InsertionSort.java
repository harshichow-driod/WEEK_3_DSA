class InsertionSort {
    public static void sortEmployeeIDs(int[] ids) {
        for (int i = 1; i < ids.length; i++) {
            int key = ids[i];
            int j = i - 1;
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
    }

    public static void printArray(int[] ids) {
        for (int i = 0; i < ids.length; i++) {
            System.out.print(ids[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] employeeIDs = {105, 102, 103, 101, 104};
        printArray(employeeIDs);
        sortEmployeeIDs(employeeIDs);
        printArray(employeeIDs);
    }
}
