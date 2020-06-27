import java.util.ArrayList;
import java.util.List;

public class Problem442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int a = Math.abs(num) - 1;
            if (nums[a] > 0) nums[a] *= -1;
            else list.add(a + 1);
        }
        return list;

    }
}
