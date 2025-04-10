import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Program9 {
    public static void main(String[] args) {
        String str = "hello";
        int iterations = 1000000;

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

        String fileName = "largeFile.txt";
        int wordCount = 0;

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            startTime = System.nanoTime();
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            endTime = System.nanoTime();
            System.out.println("FileReader word count: " + wordCount);
            System.out.println("FileReader time: " + (endTime - startTime) + " ns");
        } catch (IOException e) {
            e.printStackTrace();
        }

        wordCount = 0;
        try (FileReader fileReader = new FileReader(fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(fileReader);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            startTime = System.nanoTime();
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            endTime = System.nanoTime();
            System.out.println("InputStreamReader word count: " + wordCount);
            System.out.println("InputStreamReader time: " + (endTime - startTime) + " ns");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
