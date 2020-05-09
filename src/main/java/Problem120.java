import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        List<Integer> list = dfs(triangle, 0);
        return list.get(0);
    }

    private List<Integer> dfs(List<List<Integer>> triangle, int index) {
        if (index == triangle.size() - 1) return triangle.get(index);
        List<Integer> nextList = dfs(triangle, index + 1);
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < triangle.get(index).size(); i++) {
            int min = Math.min(triangle.get(index).get(i) + nextList.get(i), triangle.get(index).get(i) + nextList.get(i + 1));
            temp.add(min);
        }
        return temp;
    }

    public static void main(String[] args) {
        Problem120 problem120 = new Problem120();
        System.out.println(problem120.minimumTotal(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3))));
    }
}
