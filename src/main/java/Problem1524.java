public class Problem1524 {
    public int numOfSubarrays(int[] arr) {
        int K = 1, N = arr.length, count = 0;
        while (K <= N) {
            int start = 0, end = 0, sum = 0, k = K, limit = 0;
            while (end < N) {
                while (end < N && limit < k) {
                    limit++;
                    sum += arr[end];
                    end++;
                }
                if (sum % 2 == 1) count++;
                sum -= arr[start];
                start++;
                limit--;
            }
            K++;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem1524 problem1524 = new Problem1524();
        System.out.println(problem1524.numOfSubarrays(new int[]{1, 3, 5}));
        System.out.println(problem1524.numOfSubarrays(new int[]{2, 4, 6}));
        System.out.println(problem1524.numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(problem1524.numOfSubarrays(new int[]{100, 100, 99, 99}));
        System.out.println(problem1524.numOfSubarrays(new int[]{7}));
    }
}
