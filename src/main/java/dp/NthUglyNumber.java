package dp;

/**
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数
 * n 不超过1690
 */
public class NthUglyNumber {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
    private static class Ugly{
        public int[] nums = new int[1690];
        Ugly(){
            nums[0] = 1;
            int ugly, i2=0,i3=0,i5=0;
            for(int i=1;i<1690;i++){
                ugly = Math.min(Math.min(nums[i2]*2,nums[i3]*3),nums[i5]*5);
                nums[i] = ugly;
                if(ugly == nums[i2]*2) i2++;
                if(ugly == nums[i3]*3) i3++;
                if(ugly == nums[i5]*5) i5++;
            }
        }
    }
    private static Ugly u = new Ugly();

    /**
     * 这里采用预计算的方式，先计算出1690个丑数
     * 丑数可以定义为丑数*(2|3|5)，唯一存在问题的是他们计算出来之后的顺序，
     * 此处采用三指针的方式(不易想到)，这里每次取计算最小的放在当前位置，并将其下标右移
     * 具体解析可以查看官方解析:https://leetcode-cn.com/problems/ugly-number-ii/solution/chou-shu-ii-by-leetcode/
     * @param n
     * @return
     */
    private static int nthUglyNumber(int n) {
        return u.nums[n-1];
    }
}
