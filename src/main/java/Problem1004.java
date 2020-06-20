public class Problem1004 {

    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) return 0;
        int start = 0, end = 0, count = 0, max = 0;
        while (end < A.length){
            if (A[end] == 0) count++;
            while (count > K){
                if (A[start] == 0) count--;
                start++;
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        Problem1004 problem1004 = new Problem1004();
        System.out.println(problem1004.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(problem1004.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
