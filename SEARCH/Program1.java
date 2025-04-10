
public class Program1 {
    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String result = reverseString(input);
        System.out.println("Reversed string: " + result);
    }
}




