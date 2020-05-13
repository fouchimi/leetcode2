import java.util.ArrayList;
import java.util.List;

public class Problem1324 {
    public List<String> printVertically(String s) {
        if (s == null || s.length() == 0) return null;
        String[] strs = s.split(" ");
        int maxLength = Integer.MIN_VALUE;
        for (String str : strs) maxLength = Math.max(maxLength, str.length());
        char[][] chars = new char[strs.length][maxLength];
        int row = 0;
        for (String str : strs) {
            for (int j = 0; j < str.length(); j++) {
                chars[row][j] = str.charAt(j);
            }
            row++;
        }

        List<String> list = new ArrayList<>();
        String regex = "\\s+$";
        for (int col = 0; col < maxLength; col++) {
            StringBuilder sb = new StringBuilder();
            row = 0;
            for (; row < chars.length; row++) {
                if (chars[row][col] == '\u0000') sb.append(" ");
                else sb.append(chars[row][col]);
            }
            list.add(sb.toString().replaceAll(regex, ""));
        }

        return list;
    }

    public static void main(String[] args) {
        Problem1324 problem1324 = new Problem1324();
        System.out.println(problem1324.printVertically("HOW ARE YOU"));
        System.out.println(problem1324.printVertically("TO BE OR NOT TO BE"));
        System.out.println(problem1324.printVertically("CONTEST IS COMING"));
    }
}
