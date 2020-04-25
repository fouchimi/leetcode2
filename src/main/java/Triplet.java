public class Triplet {

    public static void printTriplet(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 30) {
                        System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 9, 11, 13, 15};
        Triplet.printTriplet(nums);
    }
}
