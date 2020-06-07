public class Problem718 {
    public int findLength(int[] A, int[] B) {
        int windowEnd = 0, max = Integer.MIN_VALUE;
        for (; windowEnd < A.length; windowEnd++) {
            for (int windowStart = 0; windowStart < B.length;) {
                int start = windowStart;
                while (start < B.length && B[start] != A[windowEnd]) start++;
                int end = start, tempEnd = windowEnd;
                while (end < B.length && tempEnd < A.length && B[end] == A[tempEnd]) {
                    end++;
                    tempEnd++;
                }
                max = Math.max(max, end - start);
                windowStart = start + 1;
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static void main(String[] args) {
        Problem718 problem718 = new Problem718();
        System.out.println(problem718.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
