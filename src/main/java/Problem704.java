import netscape.security.UserTarget;

public class Problem704 {

    public int search(int[] nums, int target) {
        return binarySearchUtil(nums, 0, nums.length-1, target);
    }

    private int binarySearchUtil(int[] nums, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int mid = lo + (hi-lo)/2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) return binarySearchUtil(nums, mid + 1, hi, target);
        else return binarySearchUtil(nums, lo, mid - 1, target);
    }

    public static void main(String[] args) {
        Problem704 problem704 = new Problem704();
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(problem704.search(nums, 2));
    }
}
