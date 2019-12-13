public class Problem121 {
    public int maxProfit(int[] prices) {

        int maxProfit = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, N = prices.length;
        int[] minArr = new int[N], maxArr = new int[N];

        for (int i = 0; i < N; i++) {
            min = Math.min(min, prices[i]);
            minArr[i] = min;
        }

        for (int i = N-1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxArr[i] = max;
        }

        for (int i = 0; i < N; i++) {
            maxProfit = Math.max(maxProfit, maxArr[i] - minArr[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Problem121 problem121 = new Problem121();
        System.out.println(problem121.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
