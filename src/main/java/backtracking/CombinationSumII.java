package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates={10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    /**
     * 通组合总数一一样，只需要套用回溯算法的模板
     *
     * public void backtrack(路径，选择列表){
     *     if(满足结束条件){
     *         result.add(结果);
     *     }
     *     for(选择：选择列表){
     *         做出选择;
     *         backtrack(路径，选择列表);
     *         撤销选择;
     *     }
     * }
     * 这里唯一需要注意的是对结果去重，组合数一中的去重是通过设置起始的下标来去除已经出现的组合
     * 而这道理我使用 的是先对原数组排序，然后依次选取，在满足条件时由于事先排序，则相同的待选集其元素顺序也是相同的
     * 这时候可以通过list的contains方法比较，如果存在则不加入结果集中，否则加入其中
     * @param candidates
     * @param target
     * @return
     */
    private static List<List<Integer>> combinationSum2(int[] candidates, int target){

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> candidatesList = Arrays.stream(candidates).boxed().sorted().collect(Collectors.toList());
        List<Integer> temp = new ArrayList<>();
        dfs(candidatesList,target,temp,result);
        return result;
    }

    private static void dfs(List<Integer> candidates, int target, List<Integer> temp, List<List<Integer>> result){
        if(target == 0 ){
            if(!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
            return;
        }else if(target < 0){
            return;
        }
        for(int i = 0;i<candidates.size();i++){
            temp.add(candidates.get(i));
            dfs(candidates.subList(i+1,candidates.size()),target-candidates.get(i),temp,result);
            temp.remove(temp.size()-1);
        }
    }

}
