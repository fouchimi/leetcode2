import java.util.LinkedList;
import java.util.Queue;

public class Problem934 {

    boolean[][] visited;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    Queue<int[]> q = new LinkedList<>();

    public int shortestBridge(int[][] A) {
        boolean found = false;
        int row = A.length, col = A[0].length;
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) {
                    found = true;
                    getFirstIsland(A, i, j);
                    break;
                }
            }
            if (found) break;
        }

        // BFS - expand the first island, until it reaches the second island
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur == null) break;
                for (int[] dir: dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y]) continue;
                    if (A[x][y] == 1) return res;
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
            res++;
        }
        return -1;
    }

    // DFS - find the first island
    public void getFirstIsland(int[][] A, int i, int j) {
        int row = A.length, col = A[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || A[i][j] == 0) return;
        A[i][j] = 0;
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        for (int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            getFirstIsland(A, x, y);
        }
    }

    public static void main(String[] args) {
        Problem934 problem934 = new Problem934();
        int[][] matrix = {{0, 1, 0},{0, 0, 0},{0, 0, 1}};
        System.out.println(problem934.shortestBridge(matrix));
    }
}
