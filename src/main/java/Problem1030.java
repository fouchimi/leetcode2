import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> list = new ArrayList<>();
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) list.add(new int[]{row, col});
        }
        list.sort((first, second) -> {
            int firstDist = Math.abs(first[0] - r0) + Math.abs(first[1] - c0);
            int secondDist = Math.abs(second[0] - r0) + Math.abs(second[1] - c0);
            return firstDist - secondDist;
        });
        int[][] ans = new int[list.size()][];
        list.toArray(ans);
        return ans;
    }

    public static void main(String[] args) {
        Problem1030 problem1030 = new Problem1030();
        int[][] res = problem1030.allCellsDistOrder(1, 2 ,0, 0);
        res = problem1030.allCellsDistOrder(2, 2, 0, 1);
    }
}
