import java.util.Arrays;

public class Problem62 {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] board = new int[m][n];
        for (int i = 0; i < board.length; i++) board[i][0] = 1;
        Arrays.fill(board[0], 1);
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                board[i][j] = board[i-1][j] + board[i][j-1];
            }
        }
        return board[m-1][n-1];
    }

    public static void main(String[] args) {
        Problem62 problem62 = new Problem62();
        System.out.println(problem62.uniquePaths(7, 3));
    }
}
