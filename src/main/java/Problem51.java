import java.util.ArrayList;
import java.util.List;

public class Problem51 {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) board[i][j] = '.';
        }
        boolean[][] used = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();
        helper(board, used, res, 0);
        return res;
    }

    private void helper(char[][] board, boolean[][] used, List<List<String>> res, int rowIndex) {
        if (rowIndex == board.length) {
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    sb.append(board[i][j]);
                }
                list.add(sb.toString());
                sb = new StringBuilder();
            }
            res.add(list);
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, rowIndex, col, used)) {
                used[rowIndex][col] = true;
                board[rowIndex][col] = 'Q';
                helper(board, used, res, rowIndex + 1);
                used[rowIndex][col] = false;
                board[rowIndex][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, boolean[][] used) {
        // check same row
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == 'Q') return false;
        }
        // check same col
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        // check lower left diagonal
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // check lower right diagonal
        for (int i = row, j = col; i < board.length && j < board.length; i++, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return !used[row][col];
    }

    public static void main(String[] args) {
        Problem51 problem51 = new Problem51();
        List<List<String>> res = problem51.solveNQueens(4);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }
}
