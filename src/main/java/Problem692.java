import java.util.*;

public class Problem692 {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0)  + 1);
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((first, second) -> {
            if (first.getValue() > second.getValue()) return -1;
            else if (first.getValue() < second.getValue()) return 1;
            return first.getKey().compareTo(second.getKey());
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()) pq.offer(entry);
        while (k > 0 && !pq.isEmpty()) {
            res.add(pq.poll().getKey());
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem692 problem692 = new Problem692();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(problem692.topKFrequent(words, 2));
    }
}
