import java.util.LinkedList;
import java.util.Queue;

public class Problem542 {

    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0][0];
        int rows = matrix.length, cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 1) {
                    result[i][j] = bfs(matrix, i, j);
                }
            }
        }
        return result;
    }

    private int bfs(int[][] matrix, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        int level = 0;
        q.offer(new int[]{row, col});
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] pos = q.poll();
                if(pos == null) break;
                if(matrix[pos[0]][pos[1]] == 0) return level;
                // top neighbor
                if (isValid(pos[0]-1, pos[1], matrix)) q.offer(new int[]{pos[0]-1, pos[1]});
                // left neighbor
                if(isValid(pos[0], pos[1]-1, matrix)) q.offer(new int[]{pos[0], pos[1]-1});
                // right neighbor
                if(isValid(pos[0], pos[1]+1, matrix)) q.offer(new int[]{pos[0], pos[1]+1});
                // bottom neighbor
                if(isValid(pos[0]+1, pos[1], matrix)) q.offer(new int[]{pos[0]+1, pos[1]});
            }
            level++;
        }
        return level;
    }

    private boolean isValid(int row, int col, int[][] matrix) {
        if(row < 0 || col < 0 || row > matrix.length-1 || col > matrix[0].length-1) return false;
        return true;
    }

    public static void main(String[] args) {
        Problem542 problem542 = new Problem542();
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] result = problem542.updateMatrix(matrix);
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
