import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 3) {
            int l = i, j = i + 1;
            for (; j < nums.length - 2;) {
                int start = j + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                    if (sum < target) {
                        int currentStart = start;
                        while (nums[currentStart] == nums[start] && start < end) start++;
                    } else {
                        int currentEnd = end;
                        while (nums[currentEnd] == nums[end] && start < end) end--;
                    }
                }
                int m = j;
                while (j < nums.length - 2 && nums[m] == nums[j]) j++;
            }
            while (l < nums.length - 3 && nums[l] == nums[i]) l++;
            i = l;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem18 problem18 = new Problem18();
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        List<List<Integer>> resultList = problem18.fourSum(nums, 0);
        for (List<Integer> list : resultList) {
            System.out.println(list);
        }
    }
}
