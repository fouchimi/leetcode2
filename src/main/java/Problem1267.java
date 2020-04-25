

public class Problem1267 {

    public class UnionFind {
        // Number of elements in this union find
        int size;
        // id[i] points to the parent of i, if id[i] = i then i is the root;
        int[] id;
        // use to track the size of each component
        int[] sz;
        // use to track the number of components in union find
        int numberOfComponents;

        public UnionFind(int N) {

            if (N <= 0) {
                throw new IllegalArgumentException("Size <= 0 is not allowed");
            }

            id = new int[N];
            sz = new int[N];
            this.size = numberOfComponents = N;

            for (int i = 0; i < N; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        private int find(int p) {
            int root = p;
            while (root != id[p]) root = id[root];

            while (p != root) {
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }

        private boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        private int componentSize(int p) {
            return sz[find(p)];
        }

        private int size() {
            return size;
        }

        private int components() {
            return numberOfComponents;
        }

        private void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return;

            if (sz[rootP] < sz[rootQ]) {
                id[rootP] = rootQ;
                sz[rootQ] += sz[rootP];
            } else {
                id[rootQ] = rootP;
                sz[rootP] += sz[rootQ];
            }
            numberOfComponents--;
        }
    }

    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int[] ans = new int[1];
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited, ans);
                    if (ans[0] > 1) count += ans[0];
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int row, int col, boolean[][] visited, int[] count) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || visited[row][col]) return;
        visited[row][col] = true;
        if (grid[row][col] == 1) {
            count[0]++;
            dfs(grid, row, col + 1, visited, count);
            dfs(grid, row + 1, col, visited, count);
            dfs(grid, row, col - 1, visited, count);
            dfs(grid, row - 1, col, visited, count);
        }
    }

    public static void main(String[] args) {
        Problem1267 problem1267 = new Problem1267();
//        System.out.println(problem1267.countServers(new int[][]{{1,0},{0,1}}));
//        System.out.println(problem1267.countServers(new int[][]{{1,0},{1,1}}));
//        System.out.println(problem1267.countServers(new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}}));

    }
}
