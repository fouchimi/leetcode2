import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem884 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] firstChars = A.split(" ");
        String[] secondChars = B.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String val : firstChars) map.put(val, map.getOrDefault(val, 0) + 1);
        for (String val : secondChars) map.put(val, map.getOrDefault(val, 0) + 1);
        List<String> list = new ArrayList<>();
        for (String key : map.keySet())
            if (map.get(key) == 1) list.add(key);
        String[] res = new String[list.size()];
        for(int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }

    public static void main(String[] args) {
        Problem884 problem884 = new Problem884();
        String[] res = problem884.uncommonFromSentences("this apple is sweet", "this apple is sour");
        for (String val : res) System.out.println(val);
    }
}
