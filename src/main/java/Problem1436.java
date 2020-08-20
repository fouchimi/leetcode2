import java.util.*;

public class Problem1436 {
    public String destCity(List<List<String>> paths) {
        if (paths == null || paths.size() == 0) return null;
        Map<String, List<String>> map = new HashMap<>();
        Set<String> destinationSet = new HashSet<>();
        for (List<String> path : paths) {
            String source = path.get(0);
            String destination = path.get(1);
            map.putIfAbsent(source, new ArrayList<>());
            map.get(source).add(destination);
            destinationSet.add(destination);
        }
        for (String city : map.keySet()) destinationSet.remove(city);

        return destinationSet.iterator().next();
    }

    public static void main(String[] args) {
        Problem1436 problem1436 = new Problem1436();
        System.out.println(problem1436.destCity(Arrays.asList(Arrays.asList("London", "New York"),
                Arrays.asList("New York", "Lima"), Arrays.asList("Lima", "Sao Paulo"))));
        System.out.println(problem1436.destCity(Arrays.asList(Arrays.asList("B", "C"), Arrays.asList("D", "B"), Arrays.asList("C", "A"))));
        System.out.println(problem1436.destCity(Arrays.asList(Arrays.asList("A", "Z"))));
    }
}
