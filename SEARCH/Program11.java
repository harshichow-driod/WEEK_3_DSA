
public class Program11 {
    public static void main(String[] args) {
        String[] sentences = {
            "The sun is shining.",
            "Java is a programming language.",
            "Linear search is useful.",
            "Binary search is more efficient."
        };
        String word = "programming";
        String result = "Not Found";
        
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                result = sentence;
                break;
            }
        }
        
        System.out.println(result);
    }
}


