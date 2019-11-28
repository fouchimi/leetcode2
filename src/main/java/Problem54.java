import java.util.ArrayList;
import java.util.List;

public class Problem54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        int size = matrix.length * matrix[0].length;
        while (list.size() < size) {
            for(int i = left; i <= right; i++) list.add(matrix[top][i]);
            top++;
            if (list.size() == size) break;
            for (int j = top; j <= bottom; j++) list.add(matrix[j][right]);
            right--;
            if (list.size() == size) break;
            for (int k = right; k >= left; k--) list.add(matrix[bottom][k]);
            bottom--;
            for (int l = bottom; l >= top; l--) list.add(matrix[l][left]);
            left++;
            if (list.size() == size) break;
        }
        return list;
    }

    public static void main(String[] args) {
        Problem54 problem54 = new Problem54();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list = problem54.spiralOrder(matrix);
        System.out.println(list);
    }
}
