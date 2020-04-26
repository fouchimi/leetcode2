public class Problem1306 {
    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0) return false;
        boolean[] visited = new boolean[arr.length];
        return canReachUtil(arr, visited, start);
    }

    private boolean canReachUtil(int[] arr, boolean[] visited, int index) {
        if (index < 0 || index > arr.length - 1 || visited[index]) return false;
        if (arr[index] == 0) return true;
        visited[index] = true;
        boolean output = canReachUtil(arr, visited, index + arr[index]) || canReachUtil(arr, visited, index - arr[index]);
        visited[index] = false;
        return output;
    }

    public static void main(String[] args) {
        Problem1306 problem1306 = new Problem1306();
//        System.out.println(problem1306.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
//        System.out.println(problem1306.canReach(new int[]{4,2,3,0,3,1,2}, 0));
        System.out.println(problem1306.canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }
}
