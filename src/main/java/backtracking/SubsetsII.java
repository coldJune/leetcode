package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */
public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        System.out.println(subsetWithDup(nums));
    }

    /**
     * 和78.子集的解法相同，只是需要先对nums进行排序来去重
     * @param nums
     * @return
     */
    private static List<List<Integer>> subsetWithDup(int[] nums){
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,temp,result);
        return result;
    }


    private static void dfs(int[] nums, int start, List<Integer> temp, List<List<Integer>> result){
        if(!result.contains(temp)){
            result.add(new ArrayList<>(temp));
        }

        for(int i = start;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(nums,i+1,temp,result);
            temp.remove(temp.size()-1);
        }
    }
}
