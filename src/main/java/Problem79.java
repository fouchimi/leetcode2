public class Problem79 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int d, boolean[][] visited) {
        if (d == word.length()) return true;
        if (row < 0 || col < 0 || row == board.length || col == board[0].length || visited[row][col] || board[row][col] != word.charAt(d)) return false;
        visited[row][col] = true;
        if (dfs(board, row, col + 1, word, d + 1, visited)) return true;
        if (dfs(board, row + 1, col, word, d + 1, visited)) return true;
        if (dfs(board, row, col - 1, word, d + 1, visited)) return true;
        if (dfs(board, row - 1, col, word, d + 1, visited)) return true;
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        Problem79 problem79 = new Problem79();
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        System.out.println(problem79.exist(board, "ABCCED"));
        System.out.println(problem79.exist(board, "SEE"));
        System.out.println(problem79.exist(board, "ABCB"));
//        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
//        System.out.println(problem79.exist(board, "AAB"));
    }
}
