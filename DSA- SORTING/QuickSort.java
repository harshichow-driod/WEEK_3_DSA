class QuickSort {
    public static void quickSortPrices(int[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);
            quickSortPrices(prices, low, pi - 1);
            quickSortPrices(prices, pi + 1, high);
        }
    }

    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return i + 1;
    }

    public static void printArray(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            System.out.print(prices[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] productPrices = {100, 400, 200, 300, 500};
        printArray(productPrices);
        quickSortPrices(productPrices, 0, productPrices.length - 1);
        printArray(productPrices);
    }
}
