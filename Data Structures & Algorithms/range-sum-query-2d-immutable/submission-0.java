class NumMatrix {
    int[][] matrix;
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int rows = matrix.length;
        int cols = matrix[0].length+1;
        sum = new int[rows][cols];

        for(int i=0; i<rows; ++i){
            for(int j=1; j<cols; ++j){
                sum[i][j] = sum[i][j-1] + matrix[i][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int row=row1; row<=row2; ++row){
            ans += sum[row][col2+1] - sum[row][col1];
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */