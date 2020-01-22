public class Problem372 {
    public int superPow (int a, int[] b){
        if (b == null || b.length == 0) return 0;
        if (a == 0 || a == 1) return a;
        //case i == 0
        int ans = doPow(a, b[0]);
        //case i > 0
        for (int i = 1; i < b.length; i++){
            int tmp = doPow(a, b[i]);
            ans = (doPow(ans, 10) * tmp) % 1337;
        }
        return ans;
    }

    private int doPow (int a, int pow) {
        if (a > 1337) a %= 1337;
        int ans = 1;
        for (int i = 0; i < pow; i++){
            ans *= a;
            if (ans > 1337) ans %= 1337;
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem372 problem372 = new Problem372();
        System.out.println(problem372.superPow(2, new int[]{1, 0}));
    }
}
