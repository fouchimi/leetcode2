import java.util.ArrayList;
import java.util.List;

public class Problem670 {
    public int maximumSwap(int num) {
        if (num == 0) return 0;
        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            list.add(0, num % 10);
            num /= 10;
        }

        List<Integer> tempList = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) > max) {
                tempList.add(0, list.get(i));
                max = list.get(i);
            } else {
                tempList.add(0, max);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < tempList.get(i)) {
                swap(list, i, list.get(i), tempList.get(i));
                break;
            }
        }

        int res = 0;
        while (!list.isEmpty()) res = 10 * res + list.remove(0);
        return res;
    }

    private void swap(List<Integer> list, int index, int p, int q) {
        int i = list.size() - 1;
        for (; i > index; i--) if (list.get(i) == q) break;
        list.set(index, q);
        list.set(i, p);
    }

    public static void main(String[] args) {
        Problem670 problem670 = new Problem670();
        System.out.println(problem670.maximumSwap(2736));
        System.out.println(problem670.maximumSwap(9973));
        System.out.println(problem670.maximumSwap(10909091));
    }
}
