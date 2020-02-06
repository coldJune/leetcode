package array;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }

    /**
     * 与三数之和的解题思路相同，但由于不需要保存过程值，所以相对简单
     *
     * 先初始化最近的数为随意三个数之和以及对原数组进行排序
     *
     * 然后设置左右双指针开始取出当前数据，左指针数据以及右指针数据求和
     * 比对该值到目标的距离和初始值到目标的距离，如果更小则更新最近距离的值
     *
     * 如果和大于目标值，则右指针向左移；如果和小于目标值，则左指针向右移；如果相等则直接返回
     * 直至左右指针碰撞，返回最近的值
     * @param nums
     * @param target
     * @return
     */
    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int threeSumClosest=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target)<Math.abs(threeSumClosest-target)){
                    threeSumClosest=sum;
                }
                if(sum>target){
                    right--;
                }else if(sum<target){
                    left++;
                }else{
                    return target;
                }
            }
        }
        return threeSumClosest;
    }
}
