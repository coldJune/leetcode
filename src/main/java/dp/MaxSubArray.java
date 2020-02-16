package dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 动态规划求解
     *
     * 需要求解最大值可以通过保留之前的和
     * 这里使用sum表示当前的求值，max表示历史最大值和当前和之中最大的数，最后返回这个数
     * 当sum<0时，表示它和当前位置的值相加没有增益，则将sum设置为当前位置的值重新开始新的求和
     * 当sum>=0时，则直接求和赋给sum
     * @param nums
     * @return
     */
    private static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for(int i=1;i<nums.length;i++){
            if(sum>0){
                sum+=nums[i];
            }else{
                sum=nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
