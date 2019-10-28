import java.util.*;

public class Problem743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        int m = times.length;
        Map<Integer, List<int []>> mp = new HashMap<>();
        Map<Integer, Integer> dist = new HashMap<>();

        for (int i=0; i<m; i++) {
            int key = times[i][0];

            if (mp.containsKey(key)) {
                List<int []> l = mp.get(key);
                l.add(times[i]);
                mp.put(key, l);
            } else {
                List<int []> l = new ArrayList<>();
                l.add(times[i]);
                mp.put(key, l);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(K);
        dist.put(K, 0);

        while (!q.isEmpty()) {
            int val = q.poll();
            int distTotal = dist.get(val);

            List<int []> l = mp.get(val);
            if (l != null) {
                for (int[] arr: l) {
                    int value = dist.getOrDefault(arr[1], -1);
                    if (value == -1) {
                        dist.put(arr[1], distTotal + arr[2]);
                        q.add(arr[1]);
                    } else if (value > distTotal + arr[2]) {
                        dist.put(arr[1], distTotal + arr[2]);
                        q.add(arr[1]);
                    }
                }
            }
        }

        if (dist.size() != N) return -1;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry: dist.entrySet()) max = Math.max(max, entry.getValue());
        return max;
    }

    public static void main(String[] args) {
        Problem743 problem743 = new Problem743();
        int[][] times = {{1,2,1},{2,3,2},{1,3,1}};
        System.out.println(problem743.networkDelayTime(times, 3, 2));
    }

}
