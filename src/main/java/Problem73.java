import java.util.LinkedList;
import java.util.Queue;

public class Problem73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int rows = matrix.length, cols = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) q.offer(new int[]{i, j});
            }
        }
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0], y = pos[1];
            int[] row = matrix[x];
            for (int i = 0; i < cols; i++) row[i] = 0;
            for (int i = 0; i < rows; i++) matrix[i][y] = 0;
        }
    }

    public static void main(String[] args) {
        Problem73 problem73 = new Problem73();
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        problem73.setZeroes(matrix);
    }
}
