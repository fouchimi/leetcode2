public class Problem7 {

    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '-') continue;
            sb.append(ch);
        }
        long res = Long.parseLong(sb.toString());
        res = sign * res;
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
        return (int) res;
    }

    public static void main(String[] args) {
        Problem7 problem7 = new Problem7();
        System.out.println(problem7.reverse(121));
        System.out.println(problem7.reverse(-123));
        System.out.println(problem7.reverse(120));
        System.out.println(problem7.reverse(-2147483648));
    }
}
