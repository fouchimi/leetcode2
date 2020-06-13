public class Problem122 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - prices[i-1]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Problem122 problem122 = new Problem122();
        System.out.println(problem122.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
