
public class Problem1497 {

    public boolean canArrange(int[] arr, int k) {
        int[] frequency = new int[k];
        for (int num : arr){
            num %= k;
            if (num < 0) num += k;
            frequency[num]++;
        }

        if (frequency[0] % 2 == 1) return false;

        for (int i = 1; i <= k/2; i++)
            if (frequency[i] != frequency[k-i]) return false;

        return true;
    }

    public static void main(String[] args) {
        Problem1497 problem1497 = new Problem1497();
        System.out.println(problem1497.canArrange(new int[]{1,2,3,4,5,10,6,7,8,9}, 5));
        System.out.println(problem1497.canArrange(new int[]{1,2,3,4,5,6}, 7));
        System.out.println(problem1497.canArrange(new int[]{1,2,3,4,5,6}, 10));
        System.out.println(problem1497.canArrange(new int[]{-10,10}, 2));
        System.out.println(problem1497.canArrange(new int[]{-1,1,-2,2,-3,3,-4,4}, 3));
    }
}
