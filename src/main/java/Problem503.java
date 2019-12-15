import java.util.Stack;

public class Problem503 {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] = -1;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()){
                result[i] = nums[stack.peek()];
            }
            stack.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Problem503 problem503 = new Problem503();
        int[] res = problem503.nextGreaterElements(new int[]{1, 2, 1});
        for (int value : res) {
            System.out.print(value + " ");
        }
    }
}
