import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem36 {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowVals = new HashMap<>();
        Map<Integer, Set<Character>> colVals = new HashMap<>();
        Map<Integer, Set<Character>> boxVals = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rowVals.putIfAbsent(i, new HashSet<>());
                    colVals.putIfAbsent(j, new HashSet<>());
                    boxVals.putIfAbsent(boxNumber(i, j), new HashSet<>());
                    if (!rowVals.get(i).add(board[i][j]) || !colVals.get(j).add(board[i][j]) || !boxVals.get(boxNumber(i, j)).add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private int boxNumber(int row, int col) {
        return ((row / 3) * 3) + (col / 3);
    }

    public static void main(String[] args) {
        Problem36 problem36 = new Problem36();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.' },
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1' },
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.' },
                {'.', '.', '.', '4', '1', '9', '.', '.', '5' },
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(problem36.isValidSudoku(board));
    }
}
