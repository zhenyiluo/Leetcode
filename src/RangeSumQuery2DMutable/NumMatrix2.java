class NumMatrix2 {
    int[][] trees;
    int[][] vals;
    int m;
    int n;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        vals = new int[m][n];
        trees = new int[m+1][n+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - vals[row][col];
        if(diff == 0) return;
        vals[row][col] = val;
        for(int i = row + 1; i <= m; i += i & (-i)){
            for(int j = col + 1; j <= n; j += j & (-j)){
                trees[i][j] += diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return query(row2 + 1, col2 + 1) - query(row2 + 1, col1) - query(row1, col2 + 1) + query(row1, col1);
    }

    private int query(int row, int col){
        int ret = 0;
        for(int i = row; i > 0; i -= i & (-i)){
            for(int j = col; j > 0; j -= j & (-j)){
                ret += trees[i][j];
            }
        }
        return ret;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */