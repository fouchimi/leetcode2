public class Problem540 {

    public int singleNonDuplicate(int[] nums) {
        if (nums == null) return 0;
        int res = 0;
        for (int val : nums) {
            res ^= val;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem540 problem540 = new Problem540();
        System.out.println(problem540.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(problem540.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
