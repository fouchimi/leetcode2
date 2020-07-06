import java.util.Arrays;
import java.util.Collections;

public class Problem1029 {

    public int twoCitySchedCost(int[][] costs) {

        int N = costs.length, totalCost = 0;
        Integer[] loss = new Integer[N];

        for (int i = 0; i < N; i++) {
            totalCost += costs[i][0];
            loss[i] = costs[i][0] - costs[i][1];
        }

        Arrays.sort(loss, Collections.reverseOrder());

        for(int i = 0; i < N/2; i++) {
            totalCost -= loss[i];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Problem1029 problem1029 = new Problem1029();
        System.out.println(problem1029.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
        System.out.println(problem1029.twoCitySchedCost(new int[][]{{70,311},{74,927},{732,711},{126,583},{857,118},
                {97,928},{975,843},{175,221},{284,929},{816,602},{689,863},{721,888}}));
    }
}
