class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int ans = 0;
        
        int currMax = height[0];
        for(int i=1; i<n; ++i){
            leftMax[i] = currMax;
            currMax = Math.max(currMax, height[i]);
        }

        currMax = height[n-1];
        for(int i=n-2; i>=0; --i){
            rightMax[i] = currMax;
            currMax = Math.max(currMax, height[i]);
        }

        for(int i=1; i<n-1; ++i){
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            ans += Math.max(water, 0);
        }

        return ans;
    }
}
