import java.util.Arrays;

public class Problem1451 {
    public String arrangeWords(String text) {
        if (text == null || text.length() == 0) return null;
        String[] words = text.toLowerCase().split(" ");
        Arrays.sort(words, (first, second) -> {
            if (first.length() < second.length()) return -1;
            else if (first.length() > second.length()) return 1;
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        for (String word : words) sb.append(word).append(" ");
        text = sb.toString().trim();
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    public static void main(String[] args) {
        Problem1451 problem1451 = new Problem1451();
        System.out.println(problem1451.arrangeWords("Leetcode is cool"));
        System.out.println(problem1451.arrangeWords("On and keep calm code"));
        System.out.println(problem1451.arrangeWords("To be or not to be"));
    }
}
