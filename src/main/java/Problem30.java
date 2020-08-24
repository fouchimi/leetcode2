import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem30 {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null) return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int n = words.length, m = words[0].length();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - m * n; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = n, j = i;
            while (k > 0) {
                String str = s.substring(j, j + m);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                k--;
                j += m;
            }
            if (k == 0) res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Problem30 problem30 = new Problem30();
//        List<Integer> list = problem30.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
//        List<Integer> l = problem30.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});
        problem30.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"});

    }

}
