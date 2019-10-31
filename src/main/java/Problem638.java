import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem638 {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, 0);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int k) {
        if (k == special.size()) {
            int total = 0;
            for (int i = 0; i < price.size(); i++) {
                total += price.get(i) * needs.get(i);
            }

            return total;
        }

        int pay = dfs(price, special, needs, k + 1);

        List<Integer> offer = special.get(k);
        List<Integer> leftover = new ArrayList<>();

        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < offer.get(i)) break;
            leftover.add(needs.get(i) - offer.get(i));
        }

        if (leftover.size() == needs.size()) {
            pay = Math.min(pay, offer.get(offer.size() - 1) + dfs(price, special, leftover, k));
        }

        return pay;
    }

    public static void main(String[] args) {
        Problem638 problem638 = new Problem638();
        List<Integer> price = Arrays.asList(2, 5);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10));
        List<Integer> needs = Arrays.asList(3, 2);
        System.out.println(problem638.shoppingOffers(price, special, needs));
    }
}
