package dp;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }

    /**
     * 每天可能存在三种状态
     * sold：卖出
     * rest：什么都不做
     * hold：持仓
     *
     * sold:
     * 前一天hold，当日卖出股票
     *
     * rest:
     * 前一天sold处于冷冻期
     * 前一天rest，当日继续rest
     *
     * hold:
     * 前一天rest，当日买入股票
     * 前一天hold，当日继续hold
     *
     * 则可得出
     *
     * sold[i] = hold[i-1]+price[i]
     * rest[i] = max(rest[i-1],sold[i-1])
     * hold[i] = max(rest[i-1]-price[i],hold[i-1])
     *
     * 解析详见：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/309-zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-q/
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        int sold = 0, rest = 0, hold = Integer.MIN_VALUE;
        for (int p : prices) {
            int pre_sold = sold;
            sold = hold + p;
            hold = Math.max(hold, rest - p);
            rest = Math.max(rest, pre_sold);
        }
        return Math.max(sold, rest);

    }
}
