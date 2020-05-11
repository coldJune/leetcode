package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates={2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtracking(candidates,0,target,temp,result);
        return result;
    }

    private static void backtracking(int[] canditates,int start,int target, List<Integer> temp, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }else if(target <0){
            return;
        }
        for(int i=start;i<canditates.length;i++){
            temp.add(canditates[i]);
            backtracking(canditates,i,target-canditates[i],temp,result);
            temp.remove(temp.size()-1);
        }
    }
}
