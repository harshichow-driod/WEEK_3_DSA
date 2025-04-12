public class Program3 {

    public static void main(String[] args) {
        int operationsCount1K = 1000;
        int operationsCount10K = 10000;
        int operationsCount1M = 1000000;

        System.out.println("String - 1,000 operations: " + concatenateUsingString(operationsCount1K) + "ms");
        System.out.println("StringBuilder - 1,000 operations: " + concatenateUsingStringBuilder(operationsCount1K) + "ms");
        System.out.println("StringBuffer - 1,000 operations: " + concatenateUsingStringBuffer(operationsCount1K) + "ms");

        System.out.println("String - 10,000 operations: " + concatenateUsingString(operationsCount10K) + "ms");
        System.out.println("StringBuilder - 10,000 operations: " + concatenateUsingStringBuilder(operationsCount10K) + "ms");
        System.out.println("StringBuffer - 10,000 operations: " + concatenateUsingStringBuffer(operationsCount10K) + "ms");

        System.out.println("String - 1,000,000 operations: " + concatenateUsingString(operationsCount1M) + "ms");
        System.out.println("StringBuilder - 1,000,000 operations: " + concatenateUsingStringBuilder(operationsCount1M) + "ms");
        System.out.println("StringBuffer - 1,000,000 operations: " + concatenateUsingStringBuffer(operationsCount1M) + "ms");
    }

    public static long concatenateUsingString(int operationsCount) {
        long startTime = System.nanoTime();
        String result = "";
        for (int i = 0; i < operationsCount; i++) {
            result += "String" + i;
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    public static long concatenateUsingStringBuilder(int operationsCount) {
        long startTime = System.nanoTime();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < operationsCount; i++) {
            result.append("String").append(i);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    public static long concatenateUsingStringBuffer(int operationsCount) {
        long startTime = System.nanoTime();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < operationsCount; i++) {
            result.append("String").append(i);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }
}
