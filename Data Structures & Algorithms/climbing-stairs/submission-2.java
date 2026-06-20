class Solution {
    public int allPaths(int n, int[] dp){
        if(n <= 2) return dp[n];

        if(dp[n] == 0){
            dp[n] = allPaths(n-1, dp) + allPaths(n-2, dp);
        } 

        return dp[n];
    }
    
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        if(n <= 2) return dp[n];

        return allPaths(n-1, dp) + allPaths(n-2, dp);
    }
}
