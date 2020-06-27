import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> res = new ArrayList<>();

        restaurants = veganFriendly == 1 ? applyFilter(restaurants, veganFriendly, 2) : restaurants;
        restaurants = applyFilter(restaurants, maxDistance, 4);
        restaurants = applyFilter(restaurants, maxPrice, 3);

        Arrays.sort(restaurants, (first, second) -> {
            if (first[1] != second[1]) return second[1] - first[1];
            return second[0] - first[0];
        });

        for (int[] restaurant : restaurants) res.add(restaurant[0]);

        return res;
    }

    private int[][] applyFilter(int[][] restaurants, int filter, int label) {
        List<int[]> list = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (label == 2) {
                if (restaurant[label] == filter) list.add(restaurant);
            } else {
                if (restaurant[label] <= filter) list.add(restaurant);
            }
        }
        int[][] ans = new int[list.size()][];
        list.toArray(ans);
        return ans;
    }

    private void print(List<Integer> list) {
        for (Integer value : list) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Problem1333 problem1333 = new Problem1333();
        problem1333.print(problem1333.filterRestaurants(new int[][]{{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}}, 1, 50, 10));
        problem1333.print(problem1333.filterRestaurants(new int[][]{{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}}, 0, 50, 10));
        problem1333.print(problem1333.filterRestaurants(new int[][]{{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}}, 0, 30, 3));
    }


}
