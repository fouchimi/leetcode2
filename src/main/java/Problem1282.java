import java.util.*;

public class Problem1282 {
    class Tuple {
        int id, size;
        public Tuple(int id, int size) {
            this.id = id;
            this.size = size;
        }
    }
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(tuple -> tuple.size));
        for (int i = 0; i < groupSizes.length; i++) pq.add(new Tuple(i, groupSizes[i]));
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            Tuple topTuple = pq.poll();
            if (list.isEmpty() || list.size() < topTuple.size) list.add(topTuple.id);
            if (list.size() == topTuple.size) {
                List<Integer> temp = new ArrayList<>(list);
                ans.add(temp);
                while (!list.isEmpty()) list.remove(0);
            }
        }
        return ans;
    }

    public void print(List<List<Integer>> res) {
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        Problem1282 problem1282 = new Problem1282();
        List<List<Integer>> res = problem1282.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
        problem1282.print(res);
        res = problem1282.groupThePeople(new int[]{2, 1, 3, 3, 3, 2});
        problem1282.print(res);
    }
}
