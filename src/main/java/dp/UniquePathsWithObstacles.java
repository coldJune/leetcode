package dp;

/**
 *一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * ---------------------------------------------
 * |start｜      |     |     |     |     |     |
 * ---------------------------------------------
 * |     ｜      |     |     |     |     |     |
 * ---------------------------------------------
 * |     ｜      |     |     |     |     | end |
 * ---------------------------------------------
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0,0},{0,1,0,0}, {0,0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    /**
     * 与之前的解法相同，只是新增了一个阻碍物，则需要将阻碍物地方的走法置为0表示此路不通
     * 同时初始化第一行第一列时，将从阻碍物开始及之后的所有的都置为0，
     * 这是因为只能右走和下走，无论后面是否有阻碍，只要前面被挡住了
     * 后面也就过不去了
     * 假设一个3X4的网格
     * x表示横轴，即数组第二维的长度，即网格中的4表示有4列
     * y表示横轴，即数组第一维的长度，即网格中的3表示有三行
     *
     *
     * @param obstacleGrid
     * @return
     */
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid[0].length;
        int y = obstacleGrid.length;
        int[][] step = new int[y][x];
        for(int i=0;i<x;i++){
            if(obstacleGrid[0][i]!=1){
                step[0][i]=1;
            }else{
                while(i<x){
                    step[0][i]=0;
                    i++;
                }
            }

        }

        for(int i=0;i<y;i++){
            if(obstacleGrid[i][0]!=1){
                step[i][0]=1;
            }else{
                while(i<y){
                    step[i][0]=0;
                    i++;
                }
            }

        }
        for(int i=1;i<y;i++){
            for(int j=1;j<x;j++){
                if(obstacleGrid[i][j]==1){
                    step[i][j]=0;
                }else{
                    step[i][j]=step[i-1][j]+step[i][j-1];
                }
            }
        }
        return step[y-1][x-1];
    }
}
