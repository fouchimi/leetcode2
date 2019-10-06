import java.util.ArrayList;
import java.util.List;

public class LargestNumberWithFive {
    public Integer largestNumberWithFive(int num) {
        Integer val =0;

        int n = Math.abs(num);
        int count = 0;
        int[] nums = new int[5];

        while(n !=0) {
            nums[count] = n%10;
            n = n/10;
            count++;
        }
        List<Integer> mylist = new ArrayList();
        for(int i=count-1; i >=0; i--) {
            mylist.add(nums[i]);
        }
        boolean found = false;
        for(int i=0; i<count; i++) {
            if((mylist.get(i) <= 5 && num >=0) || (mylist.get(i) >= 5 && num < 0)) {
                mylist.add(i,5);
                found = true;
                break;
            }
        }

        if(!found) {
            mylist.add(5);
        }

        for(int i=0; i < mylist.size(); i++) {
            val = (int) (val + (mylist.get(i) * Math.pow(10, count-i)));
        }

        if(num < 0) val = -val;

        return val;
    }

    public static void main(String[] args) {
        LargestNumberWithFive problem2000 = new LargestNumberWithFive();
        System.out.println(problem2000.largestNumberWithFive(268));
        System.out.println(problem2000.largestNumberWithFive(668));
        System.out.println(problem2000.largestNumberWithFive(-13));
        System.out.println(problem2000.largestNumberWithFive(-31));
        System.out.println(problem2000.largestNumberWithFive(-669));
    }
}
