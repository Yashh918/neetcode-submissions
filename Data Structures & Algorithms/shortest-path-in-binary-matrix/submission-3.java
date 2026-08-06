class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        int count = 1;
        int size = 1;
        int ans = -1;
        queue.offer(new int[] {0, 0});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            while (size > 0) {
                int[] curr = queue.poll();
                size--;

                int i = curr[0];
                int j = curr[1];

                if (i == n - 1 && j == n - 1) {
                    ans = count;
                    return ans;
                }

                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if(ni >= n || nj >= n || ni < 0 || nj < 0){
                        continue;
                    }
                    if (grid[ni][nj] == 0) {
                        queue.offer(new int[] {ni, nj});
                        grid[ni][nj] = 1;
                    }
                }
            }

            count++;
            size = queue.size();
        }

        return ans;
    }
}