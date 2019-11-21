import java.util.Arrays;

public class Problem16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int i = 0, closestSum = 0, minSteps = Integer.MAX_VALUE;
        while (i < nums.length - 2) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                int steps = 0, tempSum = sum;
                if (sum == target) return sum;
                else if (sum < target) {
                    while (tempSum < target) {
                        steps++;
                        tempSum++;
                    }
                    left++;
                } else {
                    while (tempSum > target) {
                        steps++;
                        tempSum--;
                    }
                    right--;
                }
                if (steps < minSteps) {
                    minSteps = steps;
                    closestSum = sum;
                }
            }
            i++;
        }
        return closestSum;
    }

    public static void main(String[] args) {
        Problem16 problem16 =  new Problem16();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(problem16.threeSumClosest(nums, 1));
    }
}
