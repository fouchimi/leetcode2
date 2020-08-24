import java.util.*;

public class Problem149 {
    public int maxPoints(int[][] points) {
        if(points.length <= 2) return points.length;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int local = 1;
            int dup = 0;
            int vert = 1;
            Map<String, Integer> map = new HashMap<>();
            for(int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(x1 == x2 && y1 == y2) dup++;
                else if(x2 - x1 == 0) vert++;
                else {
                    int dy = y2 - y1;
                    int dx = x2 - x1;
                    int d = GCD(dx, dy);
                    String slopeStr = dx/d + ":" + dy/d;
                    if (!map.containsKey(slopeStr)) map.put(slopeStr, 2);
                    else map.put(slopeStr, map.get(slopeStr) + 1);
                    local = Math.max(local, map.get(slopeStr));
                }
            }
            local = Math.max(local + dup, vert + dup);
            res = Math.max(res, local);
        }
        return res;
    }

    private int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }


    public static void main(String[] args) {
        Problem149 problem149 = new Problem149();
        System.out.println(problem149.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(problem149.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
        System.out.println(problem149.maxPoints(new int[][]{{4, 0}, {4, -2}, {4, 5}}));
        System.out.println(problem149.maxPoints(new int[][]{{0, 0}, {0, 0}}));
        System.out.println(problem149.maxPoints(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
        System.out.println(problem149.maxPoints(new int[][]{{3,1},{12,3},{3,1},{-6,-1}}));
        System.out.println(problem149.maxPoints(new int[][]{{1,1},{1,1},{0,0},{3,4},{4,5},{5,6},{7,8},{8,9}}));
    }
}
