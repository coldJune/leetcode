package dp;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1','1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquare(matrix));
    }

    /**
     * 首先创建一个都为0的dp矩阵，其维度和原始矩阵相同
     * dp(i,j)表示的是当前位置由1组成的最大正方形的边长
     * 从(0,0)开始，对原始矩阵中的每一个1，就将当前元素的值更新为：dp(i,j) = min(dp(i-1,j),dp(i,j-1),dp(i-1,j-1))+1，即它左边，上边，左上边的最小边长加上当前边长（因为从左上角遍历）
     * 用一个maxLen变量记录全局最大边长，然后比较其与当前边长，取最大值
     * 最后只需返回maxLen^2即可
     * @param matrix
     * @return
     */
    private static int maximalSquare(char[][] matrix){
        if(matrix.length==0){
            return 0;
        }
        int row = matrix.length;
        int cols = matrix[0].length>0?matrix[0].length:0;
        int maxLen = Integer.MIN_VALUE;
        int[][] dp = new int[row+1][cols+1];
        for(int i=1;i<=row;i++){
            for(int j=1;j<=cols;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen*maxLen;
    }
}
