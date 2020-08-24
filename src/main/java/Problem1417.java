import java.util.*;

public class Problem1417 {
    public String reformat(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        List<Character> digitsList = new ArrayList<>(), lettersList = new ArrayList<>();
        for (char ch : chars) {
            if (Character.isDigit(ch)) digitsList.add(ch);
            if (Character.isLetter(ch)) lettersList.add(ch);
        }
        if (Math.abs(digitsList.size() - lettersList.size()) > 1) return "";
        StringBuilder sb = new StringBuilder();
        int minSize = Math.min(digitsList.size(), lettersList.size()), i = 0;
        for (; i < minSize; i++) {
            if (digitsList.size() > lettersList.size()) {
              sb.append(digitsList.get(i));
              sb.append(lettersList.get(i));
            } else {
                sb.append(lettersList.get(i));
                sb.append(digitsList.get(i));
            }

        }
        if (i < digitsList.size()) sb.append(digitsList.get(i));
        if (i < lettersList.size()) sb.append(lettersList.get(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem1417 problem1417 = new Problem1417();
        System.out.println(problem1417.reformat("a0b1c2"));
        System.out.println(problem1417.reformat("leetcode"));
        System.out.println(problem1417.reformat("1229857369"));
    }
}
