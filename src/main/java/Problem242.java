import java.util.Arrays;

public class Problem242 {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return false;
        else if (s == null || t == null) return false;
        else if (s.length() == 0 && t.length() > 0) return false;
        else if (s.length() > 0 && t.length() == 0) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return new String(sChars).equals(new String(tChars));
    }

    public static void main(String[] args) {
        Problem242 problem242 = new Problem242();
//        System.out.println(problem242.isAnagram("anagram", "nagaram"));
//        System.out.println(problem242.isAnagram("rat", "car"));
        System.out.println(problem242.isAnagram("", ""));
    }
}
