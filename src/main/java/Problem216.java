import java.util.ArrayList;
import java.util.List;

public class Problem216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, new ArrayList<>(), res, 0, 1);
        return res;
    }

    private void helper(int k, int n, List<Integer> list, List<List<Integer>> res, int sum, int index) {
        if (sum > n) return;
        if (list.size() == k && sum == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < 10; i++) {
            sum += i;
            list.add(i);
            helper(k, n, list, res, sum, i + 1);
            list.remove(list.size() - 1);
            sum -= i;
        }
    }

    public static void main(String[] args) {
        Problem216 problem216 = new Problem216();
        List<List<Integer>> res = problem216.combinationSum3(3, 9);
        for (List<Integer> list : res) System.out.println(list);
    }
}
