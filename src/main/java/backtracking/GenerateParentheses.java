package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("",n,n,result);
        return result;
    }

    private static void dfs(String current, int left,int right, List<String> result){
        if(left == 0 && right == 0){
            result.add(current);
            return;
        }
        if(left>0){
            dfs(current+"(",left-1,right,result);
        }
        if(left<right){
            dfs(current+")",left,right-1,result);
        }
    }
}
