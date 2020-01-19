public class Problem367 {

    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square > num) right = mid - 1;
            else if (square < num) left = mid + 1;
            else return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Problem367 problem367 = new Problem367();
//        System.out.println(problem367.isPerfectSquare(16));
//        System.out.println(problem367.isPerfectSquare(14));
//        System.out.println(problem367.isPerfectSquare(1));
        System.out.println(problem367.isPerfectSquare(2147483647));
    }
}
