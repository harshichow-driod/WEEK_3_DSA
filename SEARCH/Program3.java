public class Program3 {
    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"Hello", " ", "World", "!", " ", "How", " ", "are", " ", "you?"};
        String result = concatenateStrings(strings);
        System.out.println("Concatenated string: " + result);
    }
}
