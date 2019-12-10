public class Problem69 {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int start = 1, end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (Integer.MAX_VALUE / mid < mid)
                end = mid;
            else if (mid * mid < x)
                start = mid;
            else if (mid * mid > x)
                end = mid;
            else
                return mid;
        }
        return start;
    }

    public static void main(String[] args) {
        Problem69 problem69 = new Problem69();
//        System.out.println(problem69.mySqrt(16));
//        System.out.println(problem69.mySqrt(8));
        System.out.println(problem69.mySqrt(2147483647));
    }
}
