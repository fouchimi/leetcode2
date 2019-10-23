import java.util.Arrays;

public class Problem473 {
    int maxIndex = Integer.MIN_VALUE;

    public boolean makesquare(int[] nums) {
        boolean[] visited = new boolean[nums.length];

        int sum = 0;
        for(int val : nums) sum += val;
        if(sum % 4 != 0) return false;

        Arrays.sort(nums);
        maxIndex = nums.length;
        for(int i = 0; i < 4; i++) {
            if(!canMakeSide(nums, 0, maxIndex-1, sum / 4, visited)) return false;
        }
        return true;
    }

    private boolean canMakeSide(int[] nums, int sum, int endIndex, int side, boolean[] visited) {
        for(int i = endIndex; i >= 0; i--) {
            if (visited[i] || nums[i] + sum > side) continue;
            if (nums[i] + sum == side) {
                visited[i] = true;
                return true;
            } else {
                visited[i] = true;
                if (!canMakeSide(nums, sum + nums[i], i-1, side, visited)) visited[i] = false;
                else {
                    maxIndex = endIndex;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem473 problem473 = new Problem473();
        int[] nums = {1, 1, 2, 2, 2};
        System.out.println(problem473.makesquare(nums));
    }
}
