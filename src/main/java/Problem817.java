import java.util.*;

public class Problem817 {
    public int numComponents(ListNode head, int[] G) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : G) map.put(value, map.getOrDefault(value, 0) + 1);
        Map<Integer, List<Integer>> adj = new HashMap<>();
        ListNode current = head, prev;
        while (current != null) {
            prev = current;
            current = current.next;
            if (current != null && map.get(prev.val) != null && map.get(current.val) != null) {
                adj.putIfAbsent(prev.val, new ArrayList<>());
                adj.putIfAbsent(current.val, new ArrayList<>());
                adj.get(prev.val).add(current.val);
                adj.get(current.val).add(prev.val);
            }
            else if (map.get(prev.val) != null) adj.putIfAbsent(prev.val, new ArrayList<>());
            else if (current != null && map.get(current.val) != null) adj.putIfAbsent(current.val, new ArrayList<>());
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int v : adj.keySet()) {
            if(!visited.contains(v)) {
                dfs(v, adj, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int s, Map<Integer, List<Integer>> adj, Set<Integer> visited) {
        if (visited.contains(s)) return;
        visited.add(s);
        for (int w : adj.get(s)) {
            dfs(w, adj, visited);
        }
    }

    public static void main(String[] args) {
        Problem817 problem817 = new Problem817();
        //0->1->2->3
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        System.out.println(problem817.numComponents(head, new int[]{0, 1, 3}));
        //head: 0->1->2->3->4
        //G = [0, 3, 1, 4]
        ListNode h = new ListNode(0);
        h.next = new ListNode(1);
        h.next.next = new ListNode(2);
        h.next.next.next = new ListNode(3);
        h.next.next.next.next = new ListNode(4);
        System.out.println(problem817.numComponents(h, new int[]{0, 3, 1, 4}));

        ListNode he = new ListNode(0);
        System.out.println(problem817.numComponents(he, new int[]{0}));

        //[0,1,2]
        //[0,2]

        ListNode hh = new ListNode(0);
        hh.next = new ListNode(1);
        hh.next.next = new ListNode(2);
        System.out.println(problem817.numComponents(hh, new int[]{0, 2}));

        //[1,2,0,4,3]
        //[3,4,0,2,1]

        ListNode l = new ListNode(1);;
        l.next = new ListNode(2);
        l.next.next = new ListNode(0);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(3);

        System.out.println(problem817.numComponents(l, new int[]{3, 4, 0, 2, 1}));
    }
}
