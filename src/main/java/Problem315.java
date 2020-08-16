import java.util.*;

public class Problem315 {

    public List<Integer> countSmaller(int[] nums) {
        int N = nums.length;
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            arr[i][0] = nums[i];
            arr[i][2] = i;
        }
        mergeSort(arr, 0, N - 1);
        List<Integer> res = new ArrayList<>();
        for (int index = 0; index < N; index++) nums[arr[index][2]] = arr[index][1];
        for (int val : nums) res.add(val);
        return res;
    }

    private void mergeSort(int[][] nums, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start)/2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            int count = 0, k = j;
            while (k <= end) {
                if (nums[i][0] > nums[k][0]) count++;
                k++;
            }
            nums[i][1] += count;
        }
        Arrays.sort(nums, start, end + 1, Comparator.comparingInt(ints -> ints[0]));
    }

    public static void main(String[] args) {
        Problem315 problem315 = new Problem315();
        System.out.println(problem315.countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(problem315.countSmaller(new int[]{-1, -1}));
    }
}
