package dp;

import java.util.Arrays;

public class Rob {
    public static void main(String[] args) {
        int nums[] = {2,3,2};
        System.out.println(rob(nums));
    }

    /**
     * 详细题解查看：https://leetcode-cn.com/problems/house-robber-ii/solution/213-da-jia-jie-she-iidong-tai-gui-hua-jie-gou-hua-/
     * @param nums
     * @return
     */
    private static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums,0, nums.length-1)),
        myRob(Arrays.copyOfRange(nums,1,nums.length)));
    }

    private  static int myRob(int[] nums){
        int pre=0,cur=0,tmp;
        for(int num:nums){
            tmp = cur;
            cur = Math.max(pre+num,cur);
            pre = tmp;
        }
        return cur;
    }
}
