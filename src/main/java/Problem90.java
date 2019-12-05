import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), subsets, used, 0);
        return subsets;
    }

    public void dfs(int[] nums, List<Integer> subset, List<List<Integer>> subsets, boolean[] used, int index){
        subsets.add(new ArrayList<>(subset));
        if (index == nums.length) return;
        for (int i = index; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            subset.add(nums[i]);
            used[i] = true;
            dfs(nums, subset, subsets, used, i + 1);
            subset.remove(subset.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Problem90 problem90 = new Problem90();
        int[] nums = {1,2,2};
        List<List<Integer>> res = problem90.subsetsWithDup(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
