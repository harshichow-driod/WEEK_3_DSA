
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Program7 {
    public static void main(String[] args) {
        String fileName = "example.txt";

        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






