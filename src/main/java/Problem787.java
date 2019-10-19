import java.util.*;

public class Problem787 {

    class Tuple {
        int stop;
        int price;
        int city;

        public Tuple(int stop, int price, int city) {
            this.stop = stop;
            this.price = price;
            this.city = city;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Map<Integer, Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) graph.add(new HashMap<>());

        for (int[] flight : flights) {
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        Queue<Tuple> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.price));

        q.add(new Tuple(-1, 0, src));
        Set<Integer> settled = new HashSet<>();
        while (!q.isEmpty()) {
            Tuple node = q.poll();
            if (node.city == dst) return node.price;
            settled.add(node.city);
            if (node.stop < K)
                for (Map.Entry<Integer, Integer> entry : graph.get(node.city).entrySet()) {
                    if (!settled.contains(entry.getKey()))
                        q.add(new Tuple(node.stop + 1, entry.getValue() + node.price, entry.getKey()));
                }
        }
        return -1;
    }


    public static void main(String[] args){
        Problem787 problem787 = new Problem787();
        int n = 3;
//        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};

        System.out.println(problem787.findCheapestPrice(n, flights, 0, 2, 0));
    }


}
