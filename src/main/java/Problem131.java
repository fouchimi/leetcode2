import java.util.ArrayList;
import java.util.List;

public class Problem131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;
    }

    private void helper(String s, List<String> list, List<List<String>> result) {
        if (s.length() == 0) {
            List<String> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String cur = s.substring(0, i + 1);
            if (isPalindrome(cur)) {
                list.add(cur);
                helper(s.substring(i + 1), list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem131 problem131 = new Problem131();
        System.out.println(problem131.partition("aab"));
    }
}
