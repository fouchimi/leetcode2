import java.util.ArrayList;
import java.util.List;

public class Problem17 {
    private String[] alphabets = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        dfs(digits, "", 0, res);
        return res;
    }

    private void dfs(String digits, String str, int index, List<String> res) {
        if (str.length() == digits.length()) {
            res.add(str);
            return;
        }
        int value = Character.getNumericValue(digits.charAt(index));
        for (int i = 0; i < alphabets[value].length(); i++) {
            dfs(digits, str + alphabets[value].charAt(i), index + 1, res);
        }
    }

    public static void main(String[] args) {
        Problem17 problem17 = new Problem17();
        List<String> result = problem17.letterCombinations("79");
        System.out.println(result);
    }

}
