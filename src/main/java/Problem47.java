import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(nums, used, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i != 0 && nums[i] == nums[i-1] && !used[i-1])) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem47 problem47 = new Problem47();
        List<List<Integer>> res = problem47.permuteUnique(new int[] {3, 3, 0, 3});
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
