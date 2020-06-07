import java.util.ArrayDeque;
import java.util.Deque;

public class Problem1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> lq = new ArrayDeque<>(), rq = new ArrayDeque<>();
        int res = 0, lastValid = 0;
        for (int i = 0; i < nums.length; i++) {
            while (lq.size() > 0 && nums[lq.peekLast()] < nums[i]) lq.pollLast();
            while (rq.size() > 0 && nums[rq.peekLast()] > nums[i]) rq.pollLast();
            lq.offer(i);
            rq.offer(i);
            while (nums[lq.peek()] - nums[rq.peek()] > limit) {
                if (lq.peek() > rq.peek()) lastValid = rq.poll() + 1;
                else lastValid = lq.poll() + 1;
            }
            res = Math.max(res, i - lastValid + 1);

        }
        return res;
    }

    public static void main(String[] args) {
        Problem1438 problem1438 = new Problem1438();
        System.out.println(problem1438.longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(problem1438.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
    }
}
