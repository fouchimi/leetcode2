import java.util.LinkedHashMap;
import java.util.Map;

public class Problem1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) return false;
        Map<Integer, Integer> targetMap = new LinkedHashMap<>();
        Map<Integer, Integer> arrMap = new LinkedHashMap<>();
        for (int i = 0; i < target.length; i++) {
            targetMap.put(target[i], targetMap.getOrDefault(target[i], 0) + 1);
            arrMap.put(arr[i], arrMap.getOrDefault(arr[i], 0) + 1);
        }
        for (int key : targetMap.keySet()) {
            if (!arrMap.containsKey(key) || arrMap.get(key) != targetMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}
