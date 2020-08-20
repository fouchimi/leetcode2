import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[][]{p1, p2, p3, p4};
        Map<String, List<int[][]>> map = new HashMap<>();
        String DEL = ",";
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) continue;
                double dist = getDist(new int[][]{points[i], points[j]});
                double xm = (points[i][0] + points[j][0]) / 2.0;
                double ym = (points[i][1] + points[j][1]) / 2.0;
                map.computeIfAbsent(xm + DEL + ym + DEL + dist,  k -> new ArrayList<>());
                map.get(xm + DEL + ym + DEL + dist).add(new int[][]{points[i], points[j]});
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() < 2) continue;
            List<int[][]> list = map.get(key);
            p1 = list.get(0)[0];
            p2 = list.get(0)[1];
            p3 = list.get(1)[0];
            double firstLength = getDist(new int[][]{p1, p3});
            double secondLength = getDist(new int[][]{p2, p3});
            return firstLength == secondLength;
        }
        return false;
    }

    private double getDist(int[][] points) {
        int i = 0, j = 1;
        return Math.sqrt((points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                ((points[i][1] - points[j][1]) * (points[i][1] - points[j][1])));
    }

    public static void main(String[] args) {
        Problem593 problem593 = new Problem593();
        System.out.println(problem593.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
        System.out.println(problem593.validSquare(new int[]{0, 0}, new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}));
        System.out.println(problem593.validSquare(new int[]{0, 0}, new int[]{5, 0}, new int[]{5, 4}, new int[]{0, 4}));
        System.out.println(problem593.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{0, 0}, new int[]{0, 0}));
    }
}
