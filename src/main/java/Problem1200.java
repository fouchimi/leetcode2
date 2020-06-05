import java.util.*;

public class Problem1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, List<List<Integer>>> map = new LinkedHashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 == arr.length) break;
            int key = arr[i + 1] - arr[i];
            if (key < min) min = key;
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(Arrays.asList(arr[i], arr[i + 1]));
        }
        return map.get(min);
    }

    public static void main(String[] args) {
        Problem1200 problem1200 = new Problem1200();
        System.out.println(problem1200.minimumAbsDifference(new int[]{4, 2, 1, 3}));
        System.out.println(problem1200.minimumAbsDifference(new int[]{1, 3, 6, 10, 15}));
        System.out.println(problem1200.minimumAbsDifference(new int[]{3,8,-10,23,19,-4,-14,27}));
    }
}
