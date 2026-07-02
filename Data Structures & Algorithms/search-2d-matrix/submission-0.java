class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = 0;
        int middle = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m*n - 1;

        if(matrix[0][0] == target || matrix[m-1][n-1] == target) return true;

        while(l < r-1){
            middle = l + (r-l)/2;

            i = middle/n;
            j = middle%n;

            if(matrix[i][j] == target){
                return true;
            } else if(matrix[i][j] > target){
                r = middle;
            } else {
                l = middle;
            }
        }

        return false;
    }
}
