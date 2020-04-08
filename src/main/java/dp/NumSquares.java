package dp;

import java.util.Arrays;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */
public class NumSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    /**
     * 参考官方题解：https://leetcode-cn.com/problems/perfect-squares/solution/wan-quan-ping-fang-shu-by-leetcode/
     * @param n
     * @return
     */
    private static  int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int[] squares = new int[(int)Math.sqrt(n)+1];
        for(int i=1;i<squares.length;i++){
            squares[i] = i*i;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<squares.length;j++){
                if(i<squares[j]) break;
                dp[i] = Math.min(dp[i],dp[i-squares[j]]+1);
            }
        }
        return dp[n];
    }
}
