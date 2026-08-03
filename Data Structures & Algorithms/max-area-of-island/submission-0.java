class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;

        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                int currArea = dfs(grid, i, j, m, n, 0);
                maxArea = Math.max(maxArea, currArea);
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j, int m, int n, int area){
        if(i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == 0) {
            return area;
        }

        grid[i][j] = 0;
        area += 1;

        area = Math.max(area, dfs(grid, i+1, j, m, n, area));
        area = Math.max(area, dfs(grid, i-1, j, m, n, area));
        area = Math.max(area, dfs(grid, i, j+1, m, n, area));
        area = Math.max(area, dfs(grid, i, j-1, m, n, area));

        return area;
    }
}
