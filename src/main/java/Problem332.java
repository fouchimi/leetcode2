import java.util.*;

public class Problem332 {
    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            // map.putIfAbsent() is to put value if key does not exist, here we setup a pq if we meet the key the first time.
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            // add the "destination" to pq for dfs search, in lexical order by default
            map.get(ticket.get(0)).offer(ticket.get(1));
        }
        helper("JFK");
        return res;
    }

    public void helper(String departure) {
        // If destination exists. When arriving the last departure, add it to res directly
        while (map.containsKey(departure) && !map.get(departure).isEmpty()) {
            // get the next destination, departure and iterate
            helper(map.get(departure).poll());
        }
        res.add(0, departure);
    }

    public static void main(String[] args) {
        // [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        Problem332 problem332 = new Problem332();
        List<String> res = problem332.findItinerary(Arrays.asList(Arrays.asList("JFK", "KUL"), Arrays.asList("JFK", "NRT"), Arrays.asList("NRT", "JFK")));
        for(String city : res) {
            System.out.print(city + " ");
        }
    }
}
