import java.util.Map;
import java.util.TreeMap;

public class Problem1394 {

    public int findLucky(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        Map<Integer, Integer> map = new TreeMap<>((first , second) -> {
            if (first < second) return 1;
            else if (first > second) return -1;
            else return 0;
        });
        for (int key : arr) map.put(key, map.getOrDefault(key, 0) + 1);
        int luckyInt = -1;
        for (int key : map.keySet()) {
            if (map.get(key) == key) return key;
        }
        return luckyInt;
    }

    public static void main(String[] args){
        Problem1394 problem1394 = new Problem1394();
        System.out.println(problem1394.findLucky(new int[]{2, 2, 3, 4}));
        System.out.println(problem1394.findLucky(new int[]{1, 2, 2, 3, 3, 3}));
        System.out.println(problem1394.findLucky(new int[]{2, 2, 2, 3, 3}));
        System.out.println(problem1394.findLucky(new int[]{5}));
        System.out.println(problem1394.findLucky(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }
}
