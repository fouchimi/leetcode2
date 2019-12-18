import java.util.ArrayList;
import java.util.List;

public class Problem46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, used,  new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    list.add(nums[i]);
                    helper(nums, used, list, res);
                    list.remove(list.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem46 problem46 = new Problem46();
        List<List<Integer>> res = problem46.permute(new int[] {1, 2, 3});
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
