import java.util.Stack;

public class Problem901 {

    static class Pair {
        int price, day;
        Pair (int _price, int _day) {
            this.price = _price;
            this.day = _day;
        }
    }

    Stack<Pair> stack;
    int day;

    public Problem901() {
        stack = new Stack<>();
        stack.push(new Pair(Integer.MAX_VALUE, -1));
        day = 0;
    }

    public int next(int price) {
        int topPriceDay = stack.peek().day, span;
        if (price < stack.peek().price) span = day - topPriceDay;
        else {
            while (!stack.isEmpty() && stack.peek().price <= price) stack.pop();
            span = day - stack.peek().day;
        }
        stack.push(new Pair(price, day));
        day += 1;
       return span;
    }

    public static void main(String[] args) {
        Problem901 problem901 = new Problem901();
        System.out.println(problem901.next(100));
        System.out.println(problem901.next(80));
        System.out.println(problem901.next(60));
        System.out.println(problem901.next(70));
        System.out.println(problem901.next(60));
        System.out.println(problem901.next(75));
        System.out.println(problem901.next(85));
    }
}
