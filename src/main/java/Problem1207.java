import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        Set<Integer> set = new HashSet<>();
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (!set.add(value)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem1207 problem1207 = new Problem1207();
        System.out.println(problem1207.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(problem1207.uniqueOccurrences(new int[]{1, 2}));
        System.out.println(problem1207.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
