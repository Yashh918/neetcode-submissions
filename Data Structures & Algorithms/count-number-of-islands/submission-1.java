class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                islands += dfs(grid, i, j, m, n);
            }
        }

        return islands;
    }

    public int dfs(char[][] grid, int i, int j, int m, int n) {
        if(i>=m || j>=n || i<0 || j<0 || grid[i][j] == '0'){
            return 0;
        }

        grid[i][j] = '0';

        dfs(grid, i+1, j, m, n);
        dfs(grid, i-1, j, m, n);
        dfs(grid, i, j+1, m, n);
        dfs(grid, i, j-1, m, n);

        return 1;
    }
}
