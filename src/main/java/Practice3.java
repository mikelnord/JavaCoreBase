import java.util.Random;
import java.util.Scanner;

public class Practice3 {

    public static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
            "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"};

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String sl = init();
        String input = "";
        while (!input.equals(sl)) {
            System.out.println("Введите слово ");
            input = sc.nextLine();
            System.out.println(srav(input, sl));
        }
        sc.close();
    }

    public static String init() {
        Random rand = new Random();
        return words[(rand.nextInt(words.length))];
    }

    public static String srav(String input, String sl) {
        StringBuilder result = new StringBuilder();
        if (!input.equals(sl)) {
            for (int i = 0; i < input.length(); i++) {
                if (i < sl.length()) {
                    if (input.charAt(i) == sl.charAt(i)) {
                        result.append(input.charAt(i));
                    } else {
                        result.append('*');
                    }
                } else {
                    result.append('*');
                }
            }
            while (result.length() < 15) {
                result.append('*');
            }
            return result.toString();
        }
        System.out.println("Слово угаданно верно!");
        return input;
    }
}
