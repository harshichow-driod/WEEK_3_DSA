
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program8 {
    public static void main(String[] args) {
        String fileName = "userInput.txt";
        
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(fileName, true)) {

            String userInput;
            while (true) {
                System.out.print("Enter text (type 'exit' to stop): ");
                userInput = bufferedReader.readLine();
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
                fileWriter.write(userInput + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}