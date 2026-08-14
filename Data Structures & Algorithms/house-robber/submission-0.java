class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        return maxSteal(0, nums, dp);
    }

    public int maxSteal(int i, int[] nums, int[] dp){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != 0) return dp[i];

        int result = Math.max(nums[i] + maxSteal(i+2, nums, dp), maxSteal(i+1, nums, dp));
        dp[i] = result;
        return result;
    }
}
