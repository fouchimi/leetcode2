import java.util.ArrayList;
import java.util.List;

public class Problem1395 {
    public int numTeams(int[] rating) {
        if (rating == null || rating.length == 0) return 0;
        List<List<Integer>> ans = new ArrayList<>();
        dfs(rating, new ArrayList<>(), ans, 0,  false);
        dfs(rating, new ArrayList<>(), ans, 0,   true);
        return ans.size();
    }

    private void dfs(int[] rating, List<Integer> list, List<List<Integer>> res, int index, boolean flag) {
        if (list.size() == 3) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (index >= rating.length) return;
        if (flag) {
            for (int i = index; i < rating.length; i++) {
                if (!list.isEmpty() && list.get(list.size() - 1) > rating[i]) continue;
                list.add(rating[i]);
                dfs(rating, list, res, i + 1, true);
                list.remove(list.size() - 1);
            }
        }
        if (!flag) {
            for (int i = index; i < rating.length; i++) {
                if (!list.isEmpty() && list.get(list.size()-1) < rating[i]) continue;
                list.add(rating[i]);
                dfs(rating, list, res, i + 1, false);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Problem1395 problem1395 = new Problem1395();
        System.out.println(problem1395.numTeams(new int[]{2, 5, 3, 4, 1}));
        System.out.println(problem1395.numTeams(new int[]{2, 1, 3}));
        System.out.println(problem1395.numTeams(new int[]{1, 2, 3, 4}));
    }

}
