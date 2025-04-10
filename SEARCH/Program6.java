
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Program6 {
    public static void main(String[] args) {
        String fileName = "example.txt";
        String targetWord = "yourWord"; 
        int count = 0;

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            System.out.println("The word \"" + targetWord + "\" appears " + count + " times.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





