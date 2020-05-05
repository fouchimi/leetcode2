public class Problem698 {

    private int target = 0;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int x: nums) sum += x;
        if (sum %k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        target = sum/k;
        return dfs(nums, k, visited, target, 0);

    }

    private boolean dfs(int[] nums, int k, boolean[] visited, int target, int start){
        if(k == 1) return true;
        if(target == 0) return dfs(nums, k-1, visited, this.target, 0);

        for(int i = start; i< nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(dfs(nums, k, visited, target - nums[i], i+1)) return true;
                visited[i] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Problem698 problem698 = new Problem698();
//        System.out.println(problem698.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
//        System.out.println(problem698.canPartitionKSubsets(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1));
        System.out.println(problem698.canPartitionKSubsets(new int[]{2, 2 ,2, 2, 3, 4, 5}, 4));
    }

}
