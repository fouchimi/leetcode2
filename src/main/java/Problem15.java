import java.util.*;

public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int last = nums.length - 1;
        while (last >= 2) {
            int left = 0, right = last - 1, pivot = nums[last];
            while (left < right) {
                int sum = nums[left] + nums[right] + pivot;
                if (sum == 0) {
                    res.add(Arrays.asList(nums[left], nums[right], pivot));
                }
                if (sum < 0) {
                    int currentLeft = left;
                    while (nums[currentLeft] == nums[left] && left < right) {
                        left++;
                    }
                } else {
                    int currentRight = right;
                    while (nums[currentRight] == nums[right] && left < right) {
                        right--;
                    }
                }
            }
            while (last >= 2 && nums[last] == pivot) last--;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem15 problem15 = new Problem15();
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> res = problem15.threeSum(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }


    }
}
