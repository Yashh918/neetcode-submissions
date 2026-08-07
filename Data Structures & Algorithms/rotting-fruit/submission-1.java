class Solution {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j, 0});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        if (q.isEmpty())
            return -1;

        int ans = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int t = curr[2];
            ans = t;

            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni >= m || nj >= n || ni < 0 || nj < 0) {
                    continue;
                }
                if (grid[ni][nj] == 1) {
                    grid[ni][nj] = 2;
                    q.offer(new int[] {ni, nj, t + 1});
                    fresh--;
                }
            }
        }

        if (fresh == 0)
            return ans;

        return -1;
    }
}
