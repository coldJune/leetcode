package dp;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    /**
     * 定义一个dp数组用于存放第i个位置的最长上升子序列的长度，而第i个位置的值来源于小于i的第j个位置的最大致+1
     * 则状态转移方程为dp[i] = max(dp[j])+1, 其中0<j<i且nums[i]>nums[j]
     * @param nums
     * @return
     */
    private static int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;
        for(int i=1;i<nums.length;i++){
            int maxCurrent = 0;
            for(int j =0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxCurrent = Math.max(maxCurrent,dp[j]);
                }
            }
            dp[i] = maxCurrent+1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
