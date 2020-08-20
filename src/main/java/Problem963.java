import java.util.*;

public class Problem963 {
    public double minAreaFreeRect(int[][] ps) {
        Map<String, List<int[][]>> map = new HashMap<>();
        int m = ps.length;
        String DEL = ",";
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                double len = getDist(new int[][]{ps[i], ps[j]});
                double xm = (ps[i][0] + ps[j][0]) / 2.0;
                double ym = (ps[i][1] + ps[j][1]) / 2.0;
                map.computeIfAbsent(xm + DEL + ym + DEL + len, k -> new ArrayList<>());
                map.get(xm + DEL + ym + DEL + len).add(new int[][]{ps[i], ps[j]});
            }
        }
        double res = Double.MAX_VALUE;
        for (String key : map.keySet()) {
            List<int[][]> l = map.get(key);
            if (l.size() < 2) continue;
            for (int i = 0; i < l.size(); i++) {
                for (int j = i + 1; j < l.size(); j++) {
                    int[] i1 = l.get(i)[0];
                    int[] j1 = l.get(j)[0];
                    int[] j2 = l.get(j)[1];
                    double area = getDist(new int[][]{i1, j1}) * getDist(new int[][]{i1, j2});
                    res = Math.min(res, area);
                }
            }
        }
        return res < Double.MAX_VALUE ? res : 0;  // corner case;
    }

    private double getDist(int[][] ps) {
        int i = 0, j = 1;
        return Math.sqrt((ps[i][0] - ps[j][0]) * (ps[i][0] - ps[j][0]) +
                (ps[i][1] - ps[j][1]) * (ps[i][1] - ps[j][1]));
    }

    public static void main(String[] args) {
        Problem963 problem963 = new Problem963();
        System.out.println(problem963.minAreaFreeRect(new int[][]{{1,2},{2,1},{1,0},{0,1}}));
        System.out.println(problem963.minAreaFreeRect(new int[][]{{0,1},{2,1},{1,1},{1,0},{2,0}}));
        System.out.println(problem963.minAreaFreeRect(new int[][]{{0,3},{1,2},{3,1},{1,3},{2,1}}));
        System.out.println(problem963.minAreaFreeRect(new int[][]{{3,1},{1,1},{0,1},{2,1},{3,3},{3,2},{0,2},{2,3}}));
    }
}
