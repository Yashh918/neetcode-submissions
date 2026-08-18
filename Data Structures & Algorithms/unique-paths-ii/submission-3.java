class Solution {
    private int[][] dirs = {{1,0}, {0,1}};
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        return dfs(0, 0, m, n, obstacleGrid, dp);
    }

    public int dfs(int i, int j, int m, int n, int[][] grid, int[][] dp){
        if(i>=m || j>=n || i<0 || j<0 || grid[i][j] == 1) return 0;

        if(i == m-1 && j == n-1){
            return 1;
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int result = 0;
        for(int[] dir: dirs){
            result += dfs(i+dir[0], j+dir[1], m, n, grid, dp);
        }

        dp[i][j] = result;
        return result;
    }
}