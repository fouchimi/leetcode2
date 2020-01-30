import java.util.*;

public class Problem1002 {
    public List<String> commonChars(String[] A) {
        int N = A.length;
        Map<Character, Integer>[] mapList = new LinkedHashMap[N];
        for (int i = 0; i < N; i++) mapList[i] = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            String word = A[i];
            for (int j = 0; j < word.length(); j++) {
                char key = word.charAt(j);;
                mapList[i].put(key, mapList[i].getOrDefault(key, 0) + 1);
            }
        }
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = mapList[0];
        for (char key : map.keySet()) {
            int value = map.get(key);
            while (value > 0) {
                int count = 1;
                for (int i = 1; i < mapList.length; i++) {
                    Map<Character, Integer> currentMap = mapList[i];
                    if (!currentMap.containsKey(key) || currentMap.get(key) == 0) break;
                    currentMap.put(key, currentMap.get(key) - 1);
                    count++;
                }
                if (count == mapList.length) res.add(String.valueOf(key));
               value--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem1002 problem1002 = new Problem1002();
        List<String> res = problem1002.commonChars(new String[]{"bella", "label", "roller"});
        System.out.println(res);
    }


}
