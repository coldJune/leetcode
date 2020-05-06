package dp;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 *
 * 子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例:
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 说明:
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 *
 */
public class RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        int[][] matrix = {
  {3, 0, 1, 4, 2},
  {5, 6, 3, 2, 1},
  {1, 2, 0, 1, 5},
  {4, 1, 0, 1, 7},
  {1, 0, 3, 0, 5}
};
        RangeSumQuery2dImmutable rangeSumQuery2dImmutable = new RangeSumQuery2dImmutable();
        rangeSumQuery2dImmutable.NumMatrix(matrix);
        System.out.println(rangeSumQuery2dImmutable.sumRegion(2,1,4,3));
        System.out.println(rangeSumQuery2dImmutable.sumRegion(1,1,2,2));
        System.out.println(rangeSumQuery2dImmutable.sumRegion(1,2,2,4));


    }

    private int [][] dp;
    public void NumMatrix(int[][] matrix) {
        if(matrix.length == 0||matrix[0].length==0) return;
        dp = new int[matrix.length+1][matrix[0].length+1];
        for(int r = 0;r<matrix.length;r++){
            for(int c = 0;c < matrix[0].length;c++){
                dp[r+1][c+1] = dp[r+1][c] +dp[r][c+1]+matrix[r][c]-dp[r][c];
            }
        }
    }

    /**
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1] +dp[row1][col1];
    }
}
