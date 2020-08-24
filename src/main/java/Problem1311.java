import java.util.*;

public class Problem1311 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((first, second) -> {
           if (first.getValue().equals(second.getValue())) return first.getKey().compareTo(second.getKey());
           return second.getValue() - first.getValue();
        });

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            int[] friendList = friends[i];
            for (int friend : friendList) {
                map.putIfAbsent(i, new ArrayList<>());
                map.get(i).add(friend);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(id);
        int l = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (l == level) break;
            for (int i = 0; i < size; i++) {
                Integer top = q.poll();
                visited.add(top);
                List<Integer> friendList = map.get(top);
                for (int friend : friendList) {
                    if (!visited.add(friend)) continue;
                    visited.add(friend);
                    q.offer(friend);
                }
            }
            l++;
        }

        Map<String, Integer> videosMap = new HashMap<>();
        while (!q.isEmpty()) {
            int t = q.poll();
            List<String> videosList = watchedVideos.get(t);
            for (String video : videosList) {
                videosMap.put(video, videosMap.getOrDefault(video, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : videosMap.entrySet()) pq.offer(entry);
        List<String> resultList = new ArrayList<>();
        while (!pq.isEmpty()) resultList.add(pq.remove().getKey());
        return resultList;
    }

    public static void main(String[] args) {
        Problem1311 problem1311 = new Problem1311();
    }
}
