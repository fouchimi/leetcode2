public class Problem52 {
    private int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) board[i][j] = '.';
        }
        boolean[][] used = new boolean[n][n];
        helper(board, used, 0);
        return count;
    }

    private void helper(char[][] board, boolean[][] used, int rowIndex) {
        if (rowIndex == board.length) {
            count++;
            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, rowIndex, col, used)) {
                used[rowIndex][col] = true;
                board[rowIndex][col] = 'Q';
                helper(board, used, rowIndex + 1);
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
        Problem52 problem52 = new Problem52();
        System.out.println(problem52.totalNQueens(9));
    }
}
