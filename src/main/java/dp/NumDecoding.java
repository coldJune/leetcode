package dp;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6)
 *
 */
public class NumDecoding {
    public static void main(String[] args) {
        String s = "12";
        System.out.println(numDecoding(s));
    }

    /**
     *  申明：此解法是参考网友[蛋炒饭]的解法，链接：https://leetcode-cn.com/problems/decode-ways/solution/di-gui-dong-tai-gui-hua-kong-jian-ya-suo-man-man-d/
     *  其已提供比较详细的解释，此处我不在赘述
     * @param s
     * @return
     */
    private static int numDecoding(String s){
        if(s ==null || s.length()==0){
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len]=1;
        if(s.charAt(len-1)=='0'){
            dp[len-1]=0;
        }else {
            dp[len-1]=1;
        }
        for(int i=len-2;i>=0;i--){
            if(s.charAt(i)=='0'){
                dp[i]=0;
                continue;
            }
            if(((s.charAt(i)-'0')*10 +(s.charAt(i+1)-'0'))<=26){
                dp[i] = dp[i+1] + dp[i+2];
            }else {
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }
}
