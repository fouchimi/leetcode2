
public class Problem860 {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        for (int bill : bills) {
            if (bill == 5) fives++;
            else if (bill == 10 && fives > 0) {
                tens++;
                fives--;
            } else if (bill == 20 && fives > 0 && tens > 0) {
                tens--;
                fives--;
            } else if (bill == 20 && fives >= 3) fives -= 3;
            else return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Problem860 problem860 = new Problem860();
        System.out.println(problem860.lemonadeChange(new int[]{5,5,5,10,20}));
        System.out.println(problem860.lemonadeChange(new int[]{5,5,10}));
        System.out.println(problem860.lemonadeChange(new int[]{10,10}));
        System.out.println(problem860.lemonadeChange(new int[]{5,5,10,10,20}));
    }
}
