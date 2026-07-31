class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        int[][] visited = new int[m][n];
        dfs(image, visited, sr, sc, m, n, startColor, color);
        return image;
    }

    public void dfs(int[][] image, int[][] visited, int i, int j, int m, int n, int startColor, int color){
        if(i >= m || j >= n || i<0 || j<0 || visited[i][j] == 1 || image[i][j] != startColor) {
            return;
        }

        visited[i][j] = 1;
        image[i][j] = color;

        dfs(image, visited, i+1, j, m, n, startColor, color);
        dfs(image, visited, i-1, j, m, n, startColor, color);
        dfs(image, visited, i, j+1, m, n, startColor, color);
        dfs(image, visited, i, j-1, m, n, startColor, color);
    }
}