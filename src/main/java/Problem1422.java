public class Problem1422 {
    public int maxScore(String s) {
        int oneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') oneCount++;
        }

        int zeroCount = 0, maxSum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            } else {
                oneCount--;
            }
            maxSum = Math.max(maxSum, zeroCount + oneCount);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Problem1422 problem1422 = new Problem1422();
        System.out.println(problem1422.maxScore("011101"));
        System.out.println(problem1422.maxScore("00111"));
        System.out.println(problem1422.maxScore("1111"));
        System.out.println(problem1422.maxScore("00"));
    }
}
