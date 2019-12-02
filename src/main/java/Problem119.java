import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem119 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return Collections.emptyList();
        else if (rowIndex == 0) return Collections.singletonList(1);
        else if (rowIndex == 1) return Arrays.asList(1, 1);
        else {
            List<Integer> list = new ArrayList<>(Arrays.asList(1, 1));
            int k = rowIndex - 1;
            while (k > 0) {
                List<Integer> newList = new ArrayList<>();
                newList.add(0, 1);
                for (int i = 1; i < list.size(); i++) newList.add(list.get(i-1) + list.get(i));
                newList.add(1);
                list = newList;
                k--;
            }
            return list;
        }
    }

    public static void main(String[] args) {
        Problem119 problem119 = new Problem119();
        System.out.println(problem119.getRow(2));
    }
}
