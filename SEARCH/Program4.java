
public class Program4 {
    public static void main(String[] args) {
        int iterations = 1000000;
        String str = "hello";

        long startTime, endTime;

        StringBuffer stringBuffer = new StringBuffer();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ns");

        StringBuilder stringBuilder = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ns");
    }
}

