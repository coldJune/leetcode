package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums =  {1,2,3};
        System.out.println(subsets(nums));
    }
    private static List<List<Integer>> subsets(int[] nums){
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(0,nums,temp,result);
        return result;
    }

    private static void dfs(int start,int[] nums, List<Integer> temp, List<List<Integer>> result){
        if(!result.contains(temp)){
            result.add(new ArrayList<>(temp));
        }
        for(int i = start;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(i+1,nums,temp,result);
            temp.remove(temp.size()-1);
        }
    }
}
