import java.util.ArrayList;
import java.util.List;

public class Problem22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        dfs (n, n, "",  ans);
        return ans;
    }

    private void dfs (int left, int right, String parenthese,  List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(parenthese);
            return;
        }
        if (left <= right) {
            if (left > 0) {
                dfs(left - 1, right, parenthese + "(", ans);
            }
            if (right > 0) {
                dfs (left, right - 1, parenthese + ")", ans);
            }
        }
    }

    public static void main(String[] args) {
        Problem22 problem22 = new Problem22();
        List<String> result = problem22.generateParenthesis(3);
        System.out.println(result);
    }
}
