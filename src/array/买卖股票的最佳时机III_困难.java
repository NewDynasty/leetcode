package array;

import java.util.Arrays;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 */
public class 买卖股票的最佳时机III_困难 {

    /**
     * 示例 1:
     *
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2:
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
     *
     */
    public static int maxProfit(int[] prices) {
        return resolve(prices, 1, 0, 0);
    }

    public static int resolve(int[] prices, int index, int sum, int depth) {
        if (depth == 2) {
            return sum;
        }
        for (int i = index; i < prices.length; i++) {
            if (prices[i] > prices[index-1]) {
//                sum += prices[i] - prices[i-1];
                depth++;
                sum += max(prices[i] - prices[index-1], resolve(prices, i+1, sum, depth));
            }
        }
        return sum;
    }

    public static int max(int... ints) {
        int max = 0;
        for (int anInt : ints) {
            if (anInt < max) {
                max = anInt;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(a) + " : " + Arrays.toString(a));

        a = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(a) + " : " + Arrays.toString(a));

        a = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(a) + " : " + Arrays.toString(a));
    }
}
