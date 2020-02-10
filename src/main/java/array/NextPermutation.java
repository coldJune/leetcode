package array;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 原题可以理解为在数组的后面找到一个最小的数比当前数大，同时当前位置以后的数按升序排列，如果没有，则全部按升序排列
     *
     * 因为是按照字典序取，所以要从后方遍历，将数组中的元素足个固定为切分点，并在该点后面找到最小但比该点大的数，然后交换这两个数
     * 最后再将切分点后的数进行排序
     *
     * 否则对整个数组进行排序
     * @param nums
     */
    private static void nextPermutation(int[] nums) {
        int length = nums.length;
        for(int i=length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                int bigger = i+1;
                for(int j=i+1;j<length;j++){
                    if(nums[i]<nums[j]&&nums[j]<nums[bigger]){
                        bigger = j;
                    }
                }
                int tmp = nums[i];
                nums[i]=nums[bigger];
                nums[bigger] = tmp;
                Arrays.sort(nums, i+1,length);
                return;
            }
        }
        Arrays.sort(nums);
    }
}
