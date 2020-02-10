import java.util.*;

public class Problem599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> firstMap = new LinkedHashMap<>();
        Map<String, Integer> secondMap = new LinkedHashMap<>();

        for (int i = 0; i < list1.length; i++) firstMap.put(list1[i], i);
        for (int j = 0; j < list2.length; j++) secondMap.put(list2[j], j);

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> {
            if (entry1.getValue() < entry2.getValue()) return -1;
            else if (entry1.getValue() > entry2.getValue()) return 1;
            else return 0;
        });

        for (Map.Entry<String, Integer> next : firstMap.entrySet()) {
            String key = next.getKey();
            if (secondMap.containsKey(key)) {
                next.setValue(next.getValue() + secondMap.get(key));
                pq.offer(next);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            if (list.isEmpty() || list.get(0).getValue().equals(pq.peek().getValue())) list.add(pq.poll());
            else break;
        }

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i).getKey();

        return res;
    }

    private void print (String[] res) {
        for (String str : res) System.out.print(str + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Problem599 problem599 = new Problem599();
        String[] res = problem599.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"});
        problem599.print(res);
        String[] res1 = problem599.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"});
        problem599.print(res1);
    }
}
