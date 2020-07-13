package array;

/**
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 *
 * @author dynasty yq.xiong0320@gmail.com
 * @since 2020/7/9 11:53 下午
 */
public class 长度最小的子数组_中等 {

    /**
     * 示例：
     *
     * 输入：s = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     */
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return solve2(s, nums);
    }

    /**
     * 1. 暴力求解 通过
     * @timeComplexity O(n^2) 最坏情况
     * @spaceComplexity O(1)
     */
    private static int solve1(int s, int[] nums) {
        // 2,3,1,2,4,3
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = 0;
            for (int j = i, count = 1; j < nums.length; j++, count++) {
                x += nums[j];
                if (x >= s) {
                    if (min > count) {
                        min = count;
                        if (min == 1) {
                            return 1;
                        }
                    }
                    continue;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 2. 双指针法
     * @timeComplexity O(n)
     * @spaceComplexity O(1)
     */
    private static int solve2(int s, int[] nums) {
        int start = 0, end = 0, min = Integer.MAX_VALUE, sum = nums[0];
        while (start < nums.length && end < nums.length) {
            if (sum >= s) {
                if (min > end - start + 1) {
                    min = end - start + 1;
                    if (min == 1) {
                        return 1;
                    }
                }
                sum -= nums[start];
                start++;
                continue;
            }
            end++;
            if (end < nums.length) {
                sum += nums[end];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, a));

        a = new int[]{4,5,6,7,0,1,2};
        System.out.println(minSubArrayLen(3, a));

        a = new int[]{1,1};
        System.out.println(minSubArrayLen(3, a));
    }

}
