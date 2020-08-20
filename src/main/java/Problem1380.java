import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1380 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            int[] currentRow = matrix[i];
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < cols; j++) min = Math.min(min, currentRow[j]);
            map.put(min, map.getOrDefault(min, 0) + 1);
        }

        for (int i = 0; i < cols; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < rows; j++) max = Math.max(max, matrix[j][i]);
            map.put(max, map.getOrDefault(max, 0) + 1);;
            if (map.get(max) == 2) list.add(max);
        }

        return list;
    }

    public static void main(String[] args) {
        Problem1380 problem1380 = new Problem1380();
        List<Integer> list = problem1380.luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}});
        list.forEach(System.out::println);
        list = problem1380.luckyNumbers(new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}});
        list.forEach(System.out::println);
        list = problem1380.luckyNumbers(new int[][]{{7, 8}, {1, 2}});
        list.forEach(System.out::println);
    }
}
