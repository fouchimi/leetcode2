
public class Problem1020 {
    public int numEnclaves(int[][] A) {
        if(A == null || A.length == 0) return 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if (i == 0 || j == 0 || i == A.length-1 || j == A[0].length-1) {
                    if (A[i][j] == 1) {
                        dfs(A, i, j);
                    }
                }
            }
        }

        int count = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 1) count++;
            }
        }
        return count;
    }

    private void dfs(int[][] A, int row, int col) {
        if(row < 0 || col < 0 || row >= A.length || col >= A[0].length) return;
        if(A[row][col] == 2 || A[row][col] == 0) return;
        A[row][col] = 2;
        dfs(A, row, col+1);
        dfs(A, row+1, col);
        dfs(A, row, col-1);
        dfs(A, row-1, col);
    }


    public static void main(String[] args) {
        Problem1020 problem1020 = new Problem1020();
        int[][] A = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(problem1020.numEnclaves(A));
    }
}
