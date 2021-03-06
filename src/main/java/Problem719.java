import java.util.Arrays;

public class Problem719 {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int[] arr = new int[nums[nums.length-1] + 1];

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length;j++){
                arr[Math.abs(nums[i] - nums[j])]++;
            }
        }

        int count = 0;
        for(int i=0; i<arr.length; i++){
            count += arr[i];
            if(count >= k) {
                return i;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Problem719 problem719 = new Problem719();
        System.out.println(problem719.smallestDistancePair(new int[]{1, 3, 1}, 1));
    }
}
