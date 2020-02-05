package array;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水的最大值为 49。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }

    /**
     * 此题采用双指针求解
     *
     * 用leftI和rightI分别表示数组两端的下标，先求出一个原始值作为最大值
     *
     * 然后比较leftI和rightI位置的高度，那边小则移动将哪一边的位置往中间移动，直到当前位置的高度比上一个位置的高度高为止
     * 因为在移动过程中，容器的底在变小，则此时应该选取高度更高的位置，否则容器只会更小
     * 在到达指定位置后更新当前左边left的高度值为当前高度，然后重新计算容器大小，去之前和现在更大的一个
     * 然后再比较左右高度的大小，移动小的那一个的位置
     * 如此往复直至指针碰撞
     * @param heights
     * @return
     */
    private static int maxArea(int[] heights){
        int length = heights.length;
        int leftI = 0;
        int rightI = length-1;
        int left = heights[leftI];
        int right = heights[rightI];
        int max = left<right?
                (left*(rightI-leftI)):(right*(rightI-leftI));
        while(leftI<rightI){
            if(left<right){
                while(heights[++leftI]<left);
                left=heights[leftI];
            }else{
                while(heights[--rightI]<right);
                right=heights[rightI];
            }
            int area = left<right?
                    (left*(rightI-leftI)):(right*(rightI-leftI));
            max = area>max?area:max;
        }
        return max;
    }
}
