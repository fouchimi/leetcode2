import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, new ArrayList<>(), ans, 0);
        return ans;
    }

    private void helper(int[] nums, List<Integer> list, List<List<Integer>> ans, int index) {
        if (list.size() >= 2) ans.add(new ArrayList<>(list));
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            if (!used.add(num)) continue;
            if (!list.isEmpty() && num < list.get(list.size()-1)) continue;
            list.add(num);
            helper(nums, list, ans, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Problem491 problem491 = new Problem491();
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> res = problem491.findSubsequences(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }

    }
}
