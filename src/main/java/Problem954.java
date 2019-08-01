import java.util.PriorityQueue;

public class Problem954 {
    public boolean canReorderDoubled(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(a) - Math.abs(b));
        for(Integer num : A) {
            pq.offer(num);
        }
        while(!pq.isEmpty()) {
            int top = pq.poll();
            if(!pq.remove(2 * top)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem954 problem954 = new Problem954();
        int[] A = {-6,2,-6,4,-3,8,3,2,-2,6,1,-3,-4,-4,-8,4};
        System.out.println(problem954.canReorderDoubled(A));
        int[] B = {2,1,2,6};
        System.out.println(problem954.canReorderDoubled(B));
        int[] C = {3,1,3,6};
        System.out.println(problem954.canReorderDoubled(C));
        int[] D = {1,2,4,16,8,4};
        System.out.println(problem954.canReorderDoubled(D));
        int[] E = {78,26,-34,-44,21,-37,8,98,12,18,36,16,-64,-48,-4,-78,2,47,39,-17,39,-64,-46,52,18,-86,36,-52,42,5,-32,-28,12,-14,-29,48,-42,-30,-94,78,90,-8,-26,-40,20,-34,-2,32,96,-90,-4,18,-39,3,24,94,74,-11,-82,64,-11,26,1,78,56,9,11,40,2,14,37,28,33,88,96,-20,32,-96,-7,-58,-5,1,-42,47,72,41,36,48,-14,-43,25,-92,-41,94,-12,-19,-47,48,-10,-40,-92,49,-37,84,-17,22,-24,18,66,-74,-88,-22,52,-20,-46,82,-20,-32,39,96,44,-74,-45,-10,-38,-84,28,6,4,9,10,42,24,50,-22,-44,45,-22,-15,-84};
        System.out.println(problem954.canReorderDoubled(E));
    }
}
