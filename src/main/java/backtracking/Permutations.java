package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(numsList,temp,result);
        return result;
    }

    /**
     * 参照组合总数解法
     * @param nums
     * @param temp
     * @param result
     */
    private static void dfs(List<Integer> nums,List<Integer> temp, List<List<Integer>> result){
        if(nums.size() == temp.size()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i<nums.size();i++){
            if(!temp.contains(nums.get(i))){
                temp.add(nums.get(i));
                dfs(nums,temp,result);
                temp.remove(temp.size()-1);
            }
        }
    }
}
