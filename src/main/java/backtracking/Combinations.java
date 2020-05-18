package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n,k));
    }

    /**
     * 标准的回溯解法
     * @param n
     * @param k
     * @return
     */
    private static List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(1,n,k,temp,result);
        return result;
    }

    private static void dfs(int nowPosition,int n,int k, List<Integer> temp, List<List<Integer>> result){
        if(temp.size() == k){
            result.add(new ArrayList<>(temp));
        }
        for(int i =nowPosition;i<n+1;i++){
            temp.add(i);
            dfs(i+1,n,k,temp,result);
            temp.remove(temp.size()-1);
        }
    }
}
