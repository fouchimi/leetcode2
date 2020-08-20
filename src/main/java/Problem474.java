import java.util.*;

public class Problem474 {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] tuple = new int[strs.length][];
        int id = 0;
        dp= new int[strs.length+1][m+1][n+1];
        for(String s : strs){
            int zeros = 0;
            for (int i = 0; i < s.length(); i++) zeros += s.charAt(i) == '0' ? 1 : 0;
            tuple[id++] = new int[]{zeros, s.length()-zeros};
        }
        for(int i = 0; i < strs.length + 1; i++){
            for(int j = 0; j < m + 1; j++){
                for(int k = 0; k < n + 1; k++) dp[i][j][k] = -1;
            }
        }
        return dfs(tuple, 0, m, n); // tuple, i, m,n
    }

    public int dfs(int[][] tuple, int i, int m, int n){
        if(m < 0 || n < 0) return -1;

        if(dp[i][m][n] != -1) return dp[i][m][n];

        if(i == tuple.length){
            dp[i][m][n] = 0;
            return dp[i][m][n];
        }

        int max = 0;
        max = Math.max(max, Math.max(dfs(tuple, i + 1, m, n), 1 + dfs(tuple, i + 1, m - tuple[i][0], n - tuple[i][1])));
        dp[i][m][n] = max;
        return max;
    }

    public static void main(String[] args) {
        Problem474 problem474 = new Problem474();
        System.out.println(problem474.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3));
        System.out.println(problem474.findMaxForm(new String[]{"10","0","1"}, 1, 1));
        System.out.println(problem474.findMaxForm(new String[]{"10","0001","111001","1","0"}, 3, 4));
    }
}
