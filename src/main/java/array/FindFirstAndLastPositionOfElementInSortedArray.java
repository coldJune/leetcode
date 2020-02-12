package array;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
        System.out.println(Arrays.toString(searchRange(nums, 6)));
    }

    /**
     * 因为算法复杂度要求log n，所以同样是基于二分查找的思路
     * 先找到目标点，然后向左向右遍历找到左右最有一个与目标值相等的下标
     * @param nums
     * @param target
     * @return
     */
    private static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] index = {-1, -1};
        while(left<=right){
            int mid = left+((right-left)>>2);
            if(nums[mid]==target){
                int tmp=mid;
                while(++mid<=right&&nums[mid]==target);
                index[1]=mid-1;
                mid=tmp;
                while(--mid>=left&&nums[mid]==target);
                index[0]=mid+1;
                return index;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return index;
    }
}