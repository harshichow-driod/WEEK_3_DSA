import java.io.*;

public class Program4 {

    public static void main(String[] args) {
        String filePath = "largeFile.txt";

        System.out.println("FileReader - 1MB: " + readUsingFileReader(filePath, 1024 * 1024) + "ms");
        System.out.println("InputStreamReader - 1MB: " + readUsingInputStreamReader(filePath, 1024 * 1024) + "ms");

        System.out.println("FileReader - 100MB: " + readUsingFileReader(filePath, 1024 * 1024 * 100) + "ms");
        System.out.println("InputStreamReader - 100MB: " + readUsingInputStreamReader(filePath, 1024 * 1024 * 100) + "ms");

        System.out.println("FileReader - 500MB: " + readUsingFileReader(filePath, 1024 * 1024 * 500) + "ms");
        System.out.println("InputStreamReader - 500MB: " + readUsingInputStreamReader(filePath, 1024 * 1024 * 500) + "ms");
    }

    public static long readUsingFileReader(String filePath, int fileSize) {
        long startTime = System.nanoTime();
        try (FileReader fr = new FileReader(filePath)) {
            char[] buffer = new char[1024];
            int bytesRead;
            int totalBytesRead = 0;
            while ((bytesRead = fr.read(buffer)) != -1) {
                totalBytesRead += bytesRead;
                if (totalBytesRead >= fileSize) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    public static long readUsingInputStreamReader(String filePath, int fileSize) {
        long startTime = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            char[] buffer = new char[1024];
            int bytesRead;
            int totalBytesRead = 0;
            while ((bytesRead = isr.read(buffer)) != -1) {
                totalBytesRead += bytesRead;
                if (totalBytesRead >= fileSize) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }
}
