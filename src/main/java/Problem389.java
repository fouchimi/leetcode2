import java.util.Arrays;

public class Problem389 {

    public char findTheDifference(String s, String t) {
       char[] strs = s.toCharArray();
       char[] chars = t.toCharArray();
        Arrays.sort(strs);
        Arrays.sort(chars);
        for (int i = 0; i  < strs.length; i++) {
            if (strs[i] != chars[i]) return chars[i];
        }
        return chars[chars.length - 1];
    }

    public static void main(String[] args) {
        Problem389 problem389 = new Problem389();
        System.out.println(problem389.findTheDifference("abcd", "abcde"));
    }
}
