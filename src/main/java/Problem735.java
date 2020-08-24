import java.util.Stack;

public class Problem735 {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) return null;
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids) {
            if (stack.isEmpty()) stack.push(asteroid);
            else {
                if (sameDirection(stack.peek(), asteroid) || stack.peek() < 0 && asteroid > 0) stack.push(asteroid);
                else {
                    while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0 && Math.abs(asteroid) > Math.abs(stack.peek())) stack.pop();
                    if (stack.isEmpty()) stack.push(asteroid);
                    else if (sameDirection(stack.peek(), asteroid)) stack.push(asteroid);
                    else if (Math.abs(stack.peek()) == Math.abs(asteroid)) stack.pop();
                }
            }
        }
        int[] ans = new int[stack.size()];
        int N = ans.length;
        while (!stack.isEmpty()) ans[--N] = stack.pop();
        return ans;
    }

    private boolean sameDirection(int first, int second) {
        return (first < 0 && second < 0) || (first > 0 && second > 0);
    }

    private void print(int[] res) {
        for (int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem735 problem735 = new Problem735();
        int[] ans = problem735.asteroidCollision(new int[]{5, 10, -5});
        problem735.print(ans);
        ans = problem735.asteroidCollision(new int[]{8, -8});
        problem735.print(ans);
        ans = problem735.asteroidCollision(new int[]{10, 2, -5});
        problem735.print(ans);
        ans = problem735.asteroidCollision(new int[]{-2, -1, 1, 2});
        problem735.print(ans);
        ans = problem735.asteroidCollision(new int[]{-2,-2,1,-2});
        problem735.print(ans);
        ans = problem735.asteroidCollision(new int[]{-2,-2,-2,1});
        problem735.print(ans);
        ans = problem735.asteroidCollision(new int[]{-2,-2,2,-2});
        problem735.print(ans);
        ans = problem735.asteroidCollision(new int[]{-2,-1,1,-2});
        problem735.print(ans);
        ans = problem735.asteroidCollision(new int[]{1,-2,-2,-2});
        problem735.print(ans);
    }
}
