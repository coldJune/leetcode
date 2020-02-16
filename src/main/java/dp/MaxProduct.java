package dp;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 */
public class MaxProduct {
    public static void main(String[] args) {
       int[] nums1 = {2,3,-2,4};
       int[] nums2 = {-2,0,-1};
        System.out.println(maxProduct1(nums1));
        System.out.println(maxProduct1(nums2));

        System.out.println(maxProduct2(nums1));
        System.out.println(maxProduct2(nums2));

        System.out.println(maxProduct(nums1));
        System.out.println(maxProduct(nums2));
    }

    /**
     * 固定一个起点，然后遍历后面的值进行求积，每一次求积使用上一次的结果与当前值相乘，然后比较大小，更新最大值
     *
     * 时间复杂度和空间复杂度都是O(n^2)，leetcode最后一个测试用例空间溢出
     *
     * @param nums
     * @return
     */
    private static int maxProduct1(int[] nums) {
        int[][] pro = new int[nums.length][nums.length];
        pro[0][0] = nums[0];
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(i==j){
                    pro[i][j]=nums[j];
                }else{
                    pro[i][j]=pro[i][j-1]*nums[j];
                }

                max = Math.max(max,pro[i][j]);
            }
        }
        return max;
    }

    /**
     * 我们其实只需要前一个乘积即可，这时候将数组改为变量
     * 则将空间复杂度优化到O(1)
     * @param nums
     * @return
     */
    private static  int maxProduct2(int[] nums) {
        int pro=0;
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(i==j){
                    pro=nums[i];
                }else{
                    pro=pro*nums[j];
                }

                max = Math.max(max,pro);
            }
        }
        return max;
    }

    /**
     * 采用动态规划的思路求解
     * 考虑到存在负负得正的情况，需要维护两个前序值
     * 前序最大值dpMax,前序最小值doMin
     * nums[i]≥0：
     *      dpMax>0，则两个相乘只会更大，则dpMax=dpMax*nums[i]
     *      dpMax<0, 则两个相乘会变小，则dpMax=nums[i],dpMin=dpMax*nums[i];
     * nums[i]<0:
     *      dpMin>0,则两个相乘会更小，则dpMin=dpMin*nums[i]
     *      dpMin<0,则两个相乘会更大，则dpMin=nums[i],dpMax=dpMin*nums[i];
     *
     * 综上所述
     * 则 dpMax=max(dpMax*nums[i], nums[i], dpMin*nums[i])
     * dpMin = min(dpMin*nums[i],nums[i], dpMax*nums[i])
     * @param nums
     * @return
     */
    private static int maxProduct(int[] nums) {
        int max = nums[0];
        int dpMax = nums[0];
        int dpMin = nums[0];
        for(int i=1;i<nums.length;i++){
            int preMax = dpMax;
            dpMax = Math.max(dpMin*nums[i],Math.max(dpMax*nums[i],nums[i]));
            dpMin = Math.min(dpMin*nums[i], Math.min(preMax*nums[i], nums[i]));
            max = Math.max(dpMax,max);
        }
        return max;
    }
}
