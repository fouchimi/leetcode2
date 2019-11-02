import java.util.*;

public class Problem399 {

    class Edge {
        String s;
        double cost;

        Edge (String _s, double _cost) {
            this.s = _s;
            this.cost = _cost;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Set<String> vertices = new HashSet<>();
        Map<String, List<Edge>> map = new HashMap<>();
        Map<String, Boolean> visitedMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String key = equation.get(0), value = equation.get(1);
            List<Edge> l = map.get(key), rl = map.get(value);
            if (l == null) {
                l = new ArrayList<>();
                l.add(new Edge(value, values[i]));
                map.put(key, l);
            } else map.get(key).add(new Edge(value, values[i]));

            if (rl == null) {
                rl = new ArrayList<>();
                rl.add(new Edge(key, 1.0/values[i]));
                map.put(value, rl);
            } else map.get(value).add(new Edge(key, 1.0/values[i]));

            vertices.add(key);
            vertices.add(value);
            visitedMap.put(key, false);
            visitedMap.put(value, false);
        }

        double[] res = new double[queries.size()];
        Arrays.fill(res, -1.0D);
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String src = query.get(0);
            String dst = query.get(1);
            if (src.equals(dst) && vertices.contains(src) && vertices.contains(dst)) res[i] = 1.0D;
            else if (vertices.contains(src) && vertices.contains(dst)) {
                dfs(src, dst, map, visitedMap, i, 1.0D, res);
            }
        }
        return res;
    }

    private void dfs (String src, String dst, Map<String, List<Edge>> map, Map<String, Boolean> visited, int index, double val, double[] res) {
        if (src.equals(dst)) {
            res[index] = val;
            return;
        }
        visited.put(src, true);
        if (map.get(src) == null) return;
        for (Edge w : map.get(src)) {
            if (!visited.get(w.s)) {
                dfs(w.s, dst, map, visited, index, val * w.cost, res);
            }
        }
        visited.put(src, false);
    }

    public  static void main(String[] args) {
        Problem399 problem399 = new Problem399();
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a", "c"),
                Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        double[] res = problem399.calcEquation(equations, values, queries);
        for(double val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
