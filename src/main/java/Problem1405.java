import java.util.PriorityQueue;

public class Problem1405 {
    class Tuple {
        char ch;
        int freq;
        Tuple(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        Tuple[] tuples = {new Tuple('a', a), new Tuple('b', b), new Tuple('c', c)};
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);
        for (Tuple tuple : tuples) pq.offer(tuple);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Tuple top = pq.poll();
            if (top == null) break;
            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 1) == top.ch && sb.charAt(n - 2) == top.ch) {
                if (pq.isEmpty()) break;
                Tuple second = pq.poll();
                pq.offer(top);
                top = second;
            }
            if (top.freq > 0) {
                sb.append(top.ch);
                top.freq -= 1;
            }
            if (top.freq > 0) pq.offer(top);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem1405 problem1405 = new Problem1405();
        System.out.println(problem1405.longestDiverseString(1, 1, 7));
        System.out.println(problem1405.longestDiverseString(2, 2, 1));
        System.out.println(problem1405.longestDiverseString(7, 1, 0));
        System.out.println(problem1405.longestDiverseString(0, 8, 11));
    }
}
