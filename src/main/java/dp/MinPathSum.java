package dp;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

    /**
     * 和不同路径的题一样的解法和思路
     * 用一个与原矩阵相同的矩阵保存每条路径的长度，
     * 除第一行和第一列外，每个格子代表的长度有其上方和左方两个来源，这里选取其中最小的加上当前格子的大小
     * 最后返回矩阵最右下角的值
     * @param grid
     * @return
     */
    private static int minPathSum(int[][] grid) {
        int col = grid[0].length;
        int row = grid.length;
        int[][] step = new int[row][col];
        step[0][0]=grid[0][0];
        for(int i=1;i<col;i++){
            step[0][i]=step[0][i-1]+grid[0][i];
        }

        for(int i=1;i<row;i++){
            step[i][0]=step[i-1][0]+grid[i][0];
        }
        for(int i = 1;i<row;i++){
            for(int j=1;j<col;j++){
                step[i][j]=Math.min(step[i-1][j],step[i][j-1])+grid[i][j];
            }
        }
        return step[row-1][col-1];
    }
}
