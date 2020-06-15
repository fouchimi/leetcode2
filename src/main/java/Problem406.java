import java.util.*;

public class Problem406 {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new LinkedList<>();
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        for (int[] person : people) list.add(person[1], person);
        return list.toArray(people);
    }

    public static void main(String[] args) {
        Problem406 problem406 = new Problem406();
        int[][] result = problem406.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        for (int[] val : result) {
            System.out.print("[" + val[0] + "," + val[1] + "]");
        }
        System.out.println();
    }
}
