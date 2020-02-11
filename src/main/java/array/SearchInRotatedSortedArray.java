package array;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 3));

    }

    /**
     * 题目要求log n的时间复杂度，首先需要想到的是使用二分查找
     * 这里和二分查找的区别在于原素组是基于升序数组旋转的，从这里看出：
     *  原数组在旋转点前后都是有序的，且旋转点后的值都小于之前的值
     *  
     * 基于以上的分析，需要对二分查找稍加改造，
     * 和二分查找思路相同，先计算出中间下标值，这里为了防止int溢出采用了一个技巧
     * 然后比较目标值和中间值，如果相同直接返回当前下标
     * 如果不同则分情况讨论：
     * 1. 如果中间值小于右指针的值，则说明中间值落在了右有序数组内
     * ****************
     * - - -|-(-)- - - -
     * ****************
     * 这时候需要比较目标值和中间值以及右指针的值的大小，如果比中间值大比右指针的值小，则表明target在右有序数组
     * 只需要将左指针指向中间值的下标+1，
     * 否则无论是target比右指针的值大还是target比中间值小，都表明target不在中间值到右指针的值的区间内，则需要将右指针移向中间值的下标-1
     * 然后继续
     * 
     * 2. 如果中间值大于右指针的值，则说明中间值落在了左有序数组内
     * ****************
     * - - - - (-) -|- - -
     * ****************
     * 这时候需要比较目标值和中间值以及左指针的值的大小，如果比中间值小比左指针大，则表明target在左有序数组
     * 只需要将右指针指向中间值的下标-1，
     * 否则无论target比左指针的值小还是target比中间值大，都表明target不在左指针的值到中间值的区间内，此时需要将左指针移向中间值下标+1
     * 然后继续
     *
     * @param nums
     * @param target
     * @return
     */
    private static  int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left +((right-left)>>2);
            if(target == nums[mid]){
                return mid;
            }else if(nums[mid]<nums[right]){
                if(target>nums[mid]&&target<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid -1;
                }
            }else{
                if(nums[left]<=target&& target<nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid +1;
                }
            }
        }
        return -1;
    }
}
