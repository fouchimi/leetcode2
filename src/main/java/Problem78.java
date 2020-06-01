import java.util.ArrayList;
import java.util.List;

public class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums,  visited, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, boolean[] visited, ArrayList<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (!list.isEmpty() && nums[i] < list.get(list.size() - 1))) continue;
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, list, ans);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem78 problem78 = new Problem78();
        System.out.println(problem78.subsets(new int[]{1, 2, 3}));
    }
}
