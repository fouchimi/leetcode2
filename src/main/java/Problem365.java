public class Problem365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z < 0 || x + y < z) return false;
        if (z == 0) return true;
        if (x == 0) return z==y;
        if (y == 0) return z==x;
        return z % gcd( x, y) == 0;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd (b, a % b);
    }

    public static void main(String[] args) {
        Problem365 problem365 = new Problem365();
        System.out.println(problem365.canMeasureWater(0, 2, 1));
        System.out.println(problem365.canMeasureWater(0, 1, 1));
        System.out.println(problem365.canMeasureWater(0, 0, 1));
        System.out.println(problem365.canMeasureWater(1, 0, 0));
    }
}
