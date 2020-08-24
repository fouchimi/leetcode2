public class Problem457 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int N = nums.length;
        boolean[] visited = new boolean[N];
        int i = 0, start = 0;
        boolean dir = nums[0] > 0;
        boolean forward = dir;
        for (; i < N; ) {
            if (visited[i] && i == start && forward == dir) return true;
            if (visited[i] && dir != forward) return false;
            i += nums[i];
            if (i < 0)  {
                i = N - Math.abs(i);
                dir = !dir;
            }
            i = (i % N);
            visited[i] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem457 problem457 = new Problem457();
        System.out.println(problem457.circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
        System.out.println(problem457.circularArrayLoop(new int[]{-1, 2}));
        System.out.println(problem457.circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
    }
}
