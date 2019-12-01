import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (first, second) -> {
            if ((first[0] < second[0])) return -1;
            else if (first[0] > second[0]) return 1;
            return 0;
        });
        int p = 0;
        List<int[]> list = new ArrayList<>();
        while (p < intervals.length) {
            int q = p + 1;
            while (q < intervals.length && intervals[p][1] >= intervals[q][0]) {
                int max = Math.max(intervals[p][1], intervals[q][1]);
                intervals[p] = new int[]{intervals[p][0], max};
                q++;
            }
            list.add(intervals[p]);
            p = q;
        }
        int[][] result = new int[list.size()][1];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }

    public static void main(String[] args) {
        Problem56 problem56 = new Problem56();
        int[][] intervals = {{1, 4}, {0, 2}, {3, 5}, {15, 18}};
        int[][] res = problem56.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.print("[" + res[i][0] + "," + res[i][1] + "]");
        }
    }
}
