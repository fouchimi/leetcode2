
import java.util.Arrays;

public class Problem1356 {
    public int[] sortByBits(int[] arr) {
        Integer[] input = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(input, (first, second) -> {
            int firstCount = 0, secondCount = 0, tempFirst = first, tempSecond = second;
            while (tempFirst > 0) {
                if ((tempFirst & 1) == 1) firstCount++;
                tempFirst >>= 1;
            }

            while (tempSecond > 0) {
                if ((tempSecond & 1) == 1) secondCount++;
                tempSecond >>= 1;
            }
            return firstCount == secondCount ? first - second : firstCount - secondCount;
        });

        return Arrays.stream(input).mapToInt(num -> num.intValue()).toArray();
    }

    public static void main(String[] args) {
        Problem1356 problem1356 = new Problem1356();
//        int[] res = problem1356.sortByBits(new int[]{0,1,2,3,4,5,6,7,8});
        int[] r = problem1356.sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1});
    }
}
