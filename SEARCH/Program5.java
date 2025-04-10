import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Program5 {
    public static void main(String[] args) {
        String fileName = "example.txt";

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
