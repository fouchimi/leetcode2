import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1329 {
    public int[][] diagonalSort(int[][] mat) {

        int rows = mat.length - 1, cols = mat[0].length - 1;
        List<List<Integer>> first = new ArrayList<>();

        for (int k = rows; k >= 0; k--) {
            List<Integer> firstTemp = new ArrayList<>();
            int i = k, j = 0;
            while (i <= rows && j <= cols) {
                firstTemp.add(mat[i][j]);
                i++;
                j++;
            }
            Collections.sort(firstTemp);
            first.add(firstTemp);
        }

        List<List<Integer>> second = new ArrayList<>();
        for (int k = 1; k <= cols; k++) {
            List<Integer> secondTemp = new ArrayList<>();
            int i = 0, j = k;
            while (j <= cols && i <= rows) {
                secondTemp.add(mat[i][j]);
                i++;
                j++;
            }
            Collections.sort(secondTemp);
            second.add(secondTemp);
        }

        int index = 0;
        for (int k = rows; k >= 0; k--) {
            int i = k, j = 0, m = 0;
            List<Integer> currentList = first.get(index);
            while (i <= rows && j <= cols) {
                mat[i][j] = currentList.get(m);
                m++;
                i++;
                j++;
            }
            index++;
        }

        index = 0;
        for (int k = 1; k <= cols; k++) {
            int i = 0, j = k, n = 0;
            List<Integer> currentList = second.get(index);
            while (j <= cols &&  i <= rows) {
                mat[i][j] = currentList.get(n);
                n++;
                i++;
                j++;
            }
            index++;
        }

        return mat;
    }


    public static void main(String[] args) {
        Problem1329 problem1329 = new Problem1329();
        //int[][] matrix = problem1329.diagonalSort(new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}});
        int[][] matrix = problem1329.diagonalSort(new int[][] {{37,98,82,45,42}});
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
