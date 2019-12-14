public class Problem503 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{0};
        int[] res = new int[nums.length];
        int N = nums.length, i = 0;
        while (i < N) {
            int j = i + 1;
            j = j >= N ? j % N : j;
            boolean found = false;
            while (j != i) {
                if (nums[j] > nums[i]) {
                    found = true;
                    break;
                }
                j = (j + 1) % N;
            }
            res[i] = found ? nums[j] : -1;
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        Problem503 problem503 = new Problem503();
        int[] res = problem503.nextGreaterElements(new int[]{1, 2, 1});
        for (int value : res) {
            System.out.print(value + " ");
        }
    }
}
