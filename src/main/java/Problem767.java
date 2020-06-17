import java.util.*;

public class Problem767 {
    public String reorganizeString(String S) {
        if (S == null || S.length() < 2) return S;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((first, second) -> !first.getValue().equals(second.getValue()) ? second.getValue() - first.getValue() : first.getKey() - second.getKey());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) pq.offer(entry);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> firstEntry = pq.poll();
            Map.Entry<Character, Integer> secondEntry = pq.poll();
            sb.append(firstEntry.getKey());
            if (secondEntry != null) {
                secondEntry.setValue(secondEntry.getValue() - 1);
                sb.append(secondEntry.getKey());
            }
            firstEntry.setValue(firstEntry.getValue() - 1);
            if (firstEntry.getValue() > 0) pq.offer(firstEntry);
            if (secondEntry != null && secondEntry.getValue() > 0) pq.offer(secondEntry);
        }
        String res = sb.toString();
        return res.charAt(res.length() - 2) == res.charAt(res.length() - 1) ? "" : res;
    }

    public static void main(String[] args) {
        Problem767 problem767 = new Problem767();
        System.out.println(problem767.reorganizeString("aab"));
        System.out.println(problem767.reorganizeString("aaab"));
        System.out.println(problem767.reorganizeString("vvvlo"));
    }
}
