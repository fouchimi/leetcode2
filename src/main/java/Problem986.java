import java.util.ArrayList;
import java.util.List;

public class Problem986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) return new int[0][0];
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < A.length && j < B.length) {
            if (A[i][0] < B[j][0]) {
                if (A[i][1] >= B[j][0]) {
                    list.add(new int[]{Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
                }
                if (B[j][1] > A[i][1]) i++;
                else j++;
            } else if (B[j][0] < A[i][0]) {
                if (B[j][1] >= A[i][0]) {
                    list.add(new int[]{Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
                }
                if (B[j][1] > A[i][1]) i++;
                else j++;
            } else if (A[i][1] > B[j][1]) {
                list.add(new int[]{A[i][0], B[j][1]});
                j++;
            } else if (A[i][1] < B[j][1]) {
                list.add(new int[]{B[j][0], A[i][1]});
                i++;
            } else {
                list.add(A[i]);
                i++;
                j++;
            }
        }

        int[][] result = new int[list.size()][1];
        for (int k = 0; k < list.size(); k++) result[k] = list.get(k);
        return result;
    }

    public static void main(String[] args) {
        Problem986 problem986 = new Problem986();
//        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
//        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
//        int[][] A = {{4, 11}};
//        int[][] B = {{1, 2}, {8, 11}, {12, 13}, {14, 15}, {17, 19}};
        int[][] A = {{3, 5}, {9, 20}};
        int[][] B = {{4, 5}, {7, 10}, {11, 12}, {14, 15}, {16, 20}};
        int[][] result = problem986.intervalIntersection(A, B);
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();
    }
}
