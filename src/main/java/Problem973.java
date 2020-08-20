import java.util.*;

public class Problem973 {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Map.Entry<String, int[]>> pq = new PriorityQueue<>((e1, e2) -> {
            String firstDist = e1.getKey().split(":")[0];
            String secondDist = e2.getKey().split(":")[0];
            double e1Dist = Double.parseDouble(firstDist);
            double e2Dist = Double.parseDouble(secondDist);
            if (e1Dist < e2Dist) return -1;
            else if (e1Dist > e2Dist) return 1;
            return 0;
        });

        Map<String, int[]> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            double dist = getDist(new int[][]{points[i], new int[]{0, 0}});
            map.put(dist + ":" + points[i][0] + "," + points[i][1], points[i]);
        }

        for (Map.Entry<String, int[]> entry : map.entrySet()) pq.offer(entry);

        List<int[]> res = new ArrayList<>();
        while (K > 0 && !pq.isEmpty()) {
            res.add(pq.poll().getValue());
            K--;
        }

        int[][] result = new int[res.size()][1];
        for (int i = 0; i < res.size(); i++) result[i] = res.get(i);
        return result;
    }

    private double getDist(int[][] points) {
        int x = 0, y = 1;
        return Math.sqrt(((points[x][0] - points[y][0]) * (points[x][0] - points[y][0])) +
                ((points[x][1] - points[y][1]) * (points[x][1] - points[y][1]))) * 1.0;
    }

    public static void main(String[] args) {
        Problem973 problem973 = new Problem973();
//        problem973.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
        problem973.kClosest(new int[][]{{0, 1}, {1, 0}}, 2);
    }
}
