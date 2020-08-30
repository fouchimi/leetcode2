import java.util.*;

public class Problem218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return result;
        List<int[]> vertical = new ArrayList<>(buildings.length);
        for (int[] bldg : buildings) {
            vertical.add(new int[]{bldg[0], -bldg[2]});
            vertical.add(new int[]{bldg[1], bldg[2]});
        }
        // sort building edges by x coordinates, if tied, sort by y coordinates
        vertical.sort((a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        // maxPQ (largest element at top, the lambda expression in constructor is very important)
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a, b) -> (b - a));
        PQ.offer(0);    // dummy height represents lowest level
        for (int[] h : vertical) {
            int prevX = result.size() == 0 ? 0 : result.get(result.size()-1).get(0);
            int prevY = result.size() == 0 ? 0 : result.get(result.size()-1).get(1);
            if (h[1] < 0) { // beginning edge of a building
                if (-h[1] > prevY) { // only add height when higher than previous
                    result.add(Arrays.asList(h[0], -h[1]));
                }
                PQ.offer(-h[1]); // store height as active
            } else if (h[1] > 0) {  // ending edge of a building
                PQ.remove(h[1]);    // remove height (deactivate)
                // if statements checks conditions where we don't want to add height to result:
                // 1. Buildings end on the same x coordinate
                // 2. Height still active (there is another building with same height and hasn't ended)
                // 3. Building end is lower than current highest building
                if (!PQ.isEmpty() && !PQ.contains(h[1]) && h[0] != prevX && h[1] > PQ.peek()) {
                    result.add(Arrays.asList(h[0], PQ.peek()));
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Problem218 problem218 = new Problem218();
        int[][] buildings = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
//        int[][] buildings = new int[][]{{0, 2, 3}, {2, 5, 3}};
//        int[][] buildings = new int[][]{{1, 2, 1}, {1, 2, 2}, {1, 2, 3}};
//        int[][] buildings = new int[][]{{2, 4, 7}, {2, 4, 5}, {2, 4, 6}};
        List<List<Integer>> ans = problem218.getSkyline(buildings);
        for (List<Integer> l : ans) {
            System.out.println(l);
        }
    }
}
