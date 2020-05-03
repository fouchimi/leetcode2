import java.util.*;

public class Problem1424 {

    class Tuple {
        int sum, row, val;
        Tuple (int sum, int row, int val) {
            this.sum = sum;
            this.row = row;
            this.val = val;
        }
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) return null;
        Map<Integer, PriorityQueue<Tuple>> map = new TreeMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int sum = i + j;
                map.putIfAbsent(sum, new PriorityQueue<>((first, second) -> {
                    if (first.row < second.row) return 1;
                    else if (first.row > second.row) return -1;
                    return 0;
                }));
                map.get(sum).add(new Tuple(sum, i, nums.get(i).get(j)));
            }
        }

        Iterator itr = map.entrySet().iterator();
        List<Integer> list = new ArrayList<>();
        while (itr.hasNext()) {
            Map.Entry<Integer, PriorityQueue<Tuple>> entry = (Map.Entry<Integer, PriorityQueue<Tuple>>) itr.next();
            PriorityQueue<Tuple> currentQueue = entry.getValue();
            while (!currentQueue.isEmpty())list.add(currentQueue.poll().val);
        }

        int[] result = new int[list.size()];
        int index = 0;
        while (!list.isEmpty()) result[index++] = list.remove(0);
        return result;
    }

    public static void main(String[] args) {
        Problem1424 problem1424 = new Problem1424();
        //[[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
        // [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
        List<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(2);
        first.add(3);;
//        first.add(4);
//        first.add(5);
        List<Integer> second = new ArrayList<>();
        second.add(4);
//        second.add(6);
//        second.add(7);
        List<Integer> third = new ArrayList<>();
        third.add(5);
        third.add(6);
        third.add(7);
//        third.add(8);
        List<Integer> fourth = new ArrayList<>();
        fourth.add(8);
//        fourth.add(9);
//        fourth.add(10);
//        fourth.add(11);
        List<Integer> fifth = new ArrayList<>();
        fifth.add(9);
        fifth.add(10);
        fifth.add(11);
//        fifth.add(12);
//        fifth.add(13);
//        fifth.add(14);
//        fifth.add(15);
//        fifth.add(16);
        List<List<Integer>> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        list.add(fifth);;
        int[] result = problem1424.findDiagonalOrder(list);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
