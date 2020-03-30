package dp;

import java.util.ArrayList;
import java.util.List;


public class WordBreak {
    public static void main(String[] args) {
       String s = "leetcode";
       List<String> wordDict = new ArrayList<String>();
       wordDict.add("leet");
       wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }

    /**
     * 该问题可以拆分为子问题的求解，即将s划分为s'和s'',如果s'和s''满足则s自然满足条件
     * 因为是动态规划练习，这里只考虑动态规划的实现方式
     * 使用dp数组来存放s(0,i)是否满足条件，所以需要初始化n+1的数组，n为字符串长度
     * 使用下标j来划分字符串s(0,i)为s'(0,j)何s''(j+1,i)
     * 我们需要判断s'(0,j)和s''(j+1,i)是否都满足条件，则s(0,i)就满足条件，只需将dp[i]设置为true,否则移动游标j再进行划分，直至成立或者j==i
     * @param s
     * @param wordDict
     * @return
     */
    private static  boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp =new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]&& wordDict.contains(s.substring(j,i)) ){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
