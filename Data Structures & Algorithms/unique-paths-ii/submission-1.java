class Solution {
    private int[][] dirs = {{1,0}, {0,1}};
    private int paths = 0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dfs(0, 0, m, n, obstacleGrid, dp);
        return paths;
    }

    public int dfs(int i, int j, int m, int n, int[][] grid, int[][] dp){
        if(i>=m || j>=n || i<0 || j<0 || grid[i][j] == 1 || grid[i][j] == -1) return 0;

        if(i == m-1 && j == n-1){
            paths++;
            return 1;
        }

        if(dp[i][j] != 0){
            paths += dp[i][j];
            return dp[i][j];
        }

        grid[i][j] = -1;

        int result = 0;
        for(int[] dir: dirs){
            result += dfs(i+dir[0], j+dir[1], m, n, grid, dp);
        }

        grid[i][j] = 0;
        dp[i][j] = result;
        return result;
    }
}