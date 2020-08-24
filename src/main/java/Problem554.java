import java.util.*;

public class Problem554 {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int pos = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                pos += wall.get(i).get(j);
                map.put(pos, map.getOrDefault(pos, 0) + 1);
            }
        }
        return map.isEmpty() ? wall.size() : wall.size() - Collections.max(map.values());
    }

    public static void main(String[] args) {
        Problem554 problem554 = new Problem554();
        List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2, 2, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 1, 1));
        System.out.println(problem554.leastBricks(list));
    }
}
