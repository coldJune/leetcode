package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 */
public class PermuteUnique {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }
    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(numList,temp,result);
        return result;
    }

    /**
     * 此处为了去重采用先从原列表删除传递到下一层，再进行还原的思路
     * 效率有点低
     * @param nums
     * @param temp
     * @param result
     */
    private static void dfs(List<Integer> nums, List<Integer> temp, List<List<Integer>> result){
        if(nums.size()==0){
            if(!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        for(int i = 0;i<nums.size();i++){
            int num = nums.remove(i);
            temp.add(num);
            dfs(nums,temp,result);
            nums.add(i,num);
            temp.remove(temp.size()-1);
        }
    }
}
