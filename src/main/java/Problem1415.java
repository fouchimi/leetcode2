import java.util.ArrayList;
import java.util.List;

public class Problem1415 {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        helper(n, list, "", new char[]{'a', 'b', 'c'}, 0);
        return list.size() < k ? "" : list.get(k - 1);
    }

    private void helper(int n, List<String> list, String str, char[] chars, int index) {
        if (str.length() == n) {
            list.add(str);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (str.length() > 0 && str.charAt(index - 1) == chars[i]) continue;
            helper(n, list, str + "" + chars[i] , chars, index + 1);
        }
    }

    public static void main(String[] args) {
        Problem1415 problem1415 = new Problem1415();
//        System.out.println(problem1415.getHappyString(1, 3));
//        System.out.println(problem1415.getHappyString(1, 4));
        System.out.println(problem1415.getHappyString(3, 9));
        System.out.println(problem1415.getHappyString(2, 7));
        System.out.println(problem1415.getHappyString(10, 100));
    }
}
