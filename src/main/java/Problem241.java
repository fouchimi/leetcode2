import java.util.ArrayList;
import java.util.List;

public class Problem241 {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> answer = new ArrayList<>();
        if (input.length() == 1) {
            answer.add(Character.getNumericValue(input.charAt(0)));
            return answer;
        }
        int curr = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                compute(left, right, input.charAt(i), answer);
            } else {
                curr = curr * 10 + Character.getNumericValue(input.charAt(i));
            }
        }
        if (answer.size() == 0) answer.add(curr);
        return answer;
    }

    private List<Integer> compute(List<Integer> left, List<Integer> right, char op, List<Integer> answer) {
        for (Integer first : left) {
            for (Integer second : right) {
                int res = addSubtractMultiply(first, second, op);
                answer.add(res);
            }
        }
        return answer;
    }

    private int addSubtractMultiply(int a, int b, char op) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else return a * b;
    }

    public static void main(String[] args) {
        Problem241 problem241 = new Problem241();
        System.out.println(problem241.diffWaysToCompute("2*3-4*5"));
    }
}
