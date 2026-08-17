class Solution {
    private int[][] dirs = {{1,0}, {0, 1}};
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        int[][] dp = new int[m][n];
        dfs(0, 0, m, n, grid, dp);
        return dfs(0, 0, m, n, grid, dp);
    }

    private int dfs(int i, int j, int m, int n, int[][] grid, int[][] dp){
        if(i>=m || j>=n || i<0 || j<0) return 0;
        if(i == m-1 || j == n-1){
            return 1;
        }
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        
        int result=0;
        for(int[] dir : dirs){
            result += dfs(i+dir[0], j+dir[1], m, n, grid, dp);
        }

        dp[i][j] = result;
        return result;
    }
}
