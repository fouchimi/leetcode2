public class Problem42 {
    public int trap(int[] height) {
        int totalWater = 0;
        if (height == null || height.length == 0) return totalWater;

        int[] left = new int[height.length];
        left[0] = 0;

        for (int i = 0; i < height.length-1; i++){
            left[i+1] = Math.max(left[i], height[i]);
        }

        int[] right = new int[height.length];
        right[height.length - 1] = 0;

        for (int i = height.length -1; i > 0; i--){
            right[i-1] = Math.max(right[i], height[i]);
        }

        for(int i = 0; i < height.length - 1; i++){
            int min = Math.min(left[i],right[i]);
            if (min > height[i]) totalWater = totalWater + (min - height[i]);
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Problem42 problem42 = new Problem42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(problem42.trap(height));
    }
}
