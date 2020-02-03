import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeNumberSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> three = threeSum(nums);
        System.out.println(three.toString());
    }

    /**
     * 解题思路
     * 此处重点是使用双指针代替三层循环，使用map数据结构的特性去重
     *
     * 首先固定一个数，则三数之和a+b+c=0成为a+b=-c，只需要固定c,然后从头部和尾部逼近即可
     *
     * 此方法在leetcode上时间性能和空间性能均非最优
     * @param nums
     * @return
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<List<Integer>,String> map = new HashMap<List<Integer>,String>();
        int length = nums.length;
        for(int i=0;i<length-2;i++){
            int min = i+1;
            int max = length-1;
            while(min <max){
                int tmp = nums[min] + nums[max];
                if(tmp == -nums[i]){
                    List<Integer> list = new ArrayList<Integer>(3);
                    list.add(nums[i]);
                    list.add(nums[min]);
                    list.add(nums[max]);
                    map.put(list, "");
                    min+=1;
                    max-=1;
                }else if(tmp < -nums[i]){
                    min +=1;
                }else{
                    max -=1;
                }
            }
        }
        return new ArrayList<List<Integer>>(map.keySet());
    }
}
