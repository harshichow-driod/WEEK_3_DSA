class MergeSort {
    public static void mergeSortPrices(int[] prices) {
        if (prices.length < 2) return;
        int mid = prices.length / 2;
        int[] left = new int[mid];
        int[] right = new int[prices.length - mid];
        
        System.arraycopy(prices, 0, left, 0, mid);
        System.arraycopy(prices, mid, right, 0, prices.length - mid);
        
        mergeSortPrices(left);
        mergeSortPrices(right);
        
        merge(prices, left, right);
    }

    private static void merge(int[] prices, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                prices[k++] = left[i++];
            } else {
                prices[k++] = right[j++];
            }
        }
        while (i < left.length) {
            prices[k++] = left[i++];
        }
        while (j < right.length) {
            prices[k++] = right[j++];
        }
    }

    public static void printArray(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            System.out.print(prices[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] bookPrices = {500, 200, 300, 100, 400};
        printArray(bookPrices);
        mergeSortPrices(bookPrices);
        printArray(bookPrices);
    }
}
