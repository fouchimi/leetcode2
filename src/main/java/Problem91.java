public class Problem91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int value = Integer.parseInt(s.substring(i-1, i));
            if (value > 0 && value < 10) dp[i] += dp[i-1];
            value = Integer.parseInt(s.substring(i-2, i));
            if (value > 9 && value < 27) dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }
    
    public static void main(String[] args) {
        Problem91 problem91 = new Problem91();
        System.out.println(problem91.numDecodings("12"));
        System.out.println(problem91.numDecodings("226"));
    }
}
