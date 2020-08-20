public class Problem1352 {

    int[] values, product;
    int N;
    public Problem1352() {
        N = 0;
        values = new int[1];
        product = new int[1];
    }

    public void add(int num) {
        if (isFull()) {
            int size = 2 * N;
            int[] tempValues = new int[size];
            int[] tempProduct = new int[size];
            for (int i = 0; i < N; i++) {
                tempValues[i] = values[i];
                tempProduct[i] = product[i];
            }
            values = tempValues;
            product = tempProduct;
        }
        values[N] = num;
        product[N] = (N == 0 || product[N-1] == 0) ? num : product[N-1] * num;
        N++;
    }

    public int getProduct(int k) {
        int start = N - k - 1;
        int divisor = product[start];
        return divisor == 0 ? 0 : product[N - 1] / divisor;
    }

    private boolean isFull() {
        return N == values.length;
    }

    public static void main(String[] args) {
        Problem1352 problem1352 = new Problem1352();
        problem1352.add(3);
        problem1352.add(0);
        problem1352.add(2);
        problem1352.add(5);
        problem1352.add(4);
        System.out.println(problem1352.getProduct(2));
        System.out.println(problem1352.getProduct(3));
        System.out.println(problem1352.getProduct(4));
        problem1352.add(8);
        System.out.println(problem1352.getProduct(2));
    }
}
