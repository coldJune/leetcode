package array;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
       int[] nums1 = {1, 3};
       int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 此解法来源于评论
     *
     *
     * 此处采用递归二分查找的解法
     * midValue=(left+right)/2
     * 在m+n为偶数时，left/right为两个数
     * 在m+n为奇数时，left/right为同一个数
     * 这里通过java算数的除法舍位实现
     * @param nums1
     * @param nums2
     * @return
     */
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m+n+1)/2;
        int right = (m+n+2)/2;
        return (findKth(nums1,0,nums2,0,left)+findKth(nums1,0,nums2,0,right))/2;
    }

    /**
     * 求中位数可以抽象为求两个有序数组的第k个元素来求解，这里的k即为两个数组合并排序后的中位数的位置
     * 为了避免创建数组的开销，使用数组下表来筛选元素
     *
     * 如果数组1的起始位置大于或等于数组的长度，则表示数组1为空，则直接返回数组二k位置的值，数组二同理
     *
     * 如果k=1表示两个数组都只有一个元素，则返回最小的那个
     *
     * 进行二分查找，首先判断数组1的长度是否比k/2大，如果是则取相应的位置的值，否则设为最大值，对数组二做同样的判断
     * 比较两个值的大小，如果midValue1<midValue2说明数组1的前k/2个元素应该舍弃，从k/2开始重新查找长度为k-k/2的元素，
     * 反之则是舍弃数组二的前k/2个元素
     * @param nums1 数组1
     * @param start1 数组的起始位置
     * @param nums2 数组二
     * @param start2 数组二的起始位置
     * @param k 两个数组中的第k个元素
     * @return
     */
    private static double findKth(int[] nums1, int start1, int[] nums2, int start2, int k){
        if(start1 >=nums1.length) return nums2[start2+k-1];
        if(start2 >= nums2.length) return nums1[start1+k-1];
        if(k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        int midValue1 = (start1 + k/2 -1< nums1.length)?nums1[start1+k/2-1]:Integer.MAX_VALUE;
        int midValue2 = (start2 +k/2 -1 < nums2.length)? nums2[start2+k/2-1]:Integer.MAX_VALUE;
        if(midValue1<midValue2){
            return findKth(nums1,start1+k/2,nums2,start2,k-k/2);
        }else{
            return findKth(nums1,start1,nums2,start2+k/2,k-k/2);
        }

    }
}
