
public class Problem151 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder resSb = new StringBuilder();
        for (String word : words) {
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while (i < word.length()) {
                if (word.charAt(i) != ' ') sb.append(word.charAt(i));
                i++;
            }
            if (sb.length() > 0) sb.append(" ");
            resSb.insert(0, sb.toString());
        }
        return resSb.toString().trim();
    }

    public static void main(String[] args) {
        Problem151 problem151 = new Problem151();
        System.out.println(problem151.reverseWords("the sky is blue"));
        System.out.println(problem151.reverseWords("  hello world!  "));
        System.out.println(problem151.reverseWords("a good   example"));
    }
}
