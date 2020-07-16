package array;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 */
public class 非递减数列_简单 {

    /**
     * 示例 1:
     *
     * 输入: nums = [4,2,3]
     * 输出: true
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     * 示例 2:
     *
     * 输入: nums = [4,2,1]
     * 输出: false
     * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     *  
     *
     * 说明：
     *
     * 1 <= n <= 10 ^ 4
     * - 10 ^ 5 <= nums[i] <= 10 ^ 5
     */
    public static boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        return solve1(nums);
    }

    /**
     * 1. hash 哈希比较
     * @timeComplexity O(n)
     * @spaceComplexity O(n)
     */
    public static boolean solve1(int[] nums) {
//        Integer x = null;
//        Integer xIndex = null;
//        int count = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    if (x != null && x == nums[j] && xIndex == j) {
//
//                    } else {
//                        count++;
//                        x = nums[j];
//                        xIndex = j;
//                    }
//                    if (count > 1) {
//                        return false;
//                    }
//                    break;
//                }
//            }
//        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }

                nums[i + 1] = nums[i];
                for (int j = 0; j < nums.length - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 2. bubbling compare k冒泡比较
     * @timeComplexity O(n*(k-1))
     * @spaceComplexity O(1)
     */
    public static boolean solve2(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1, c = 0; j < nums.length && c < k; j++, c++) {
                if (Math.abs((long) nums[i] - nums[j]) <= t && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 3. sort and compare 排序后比较
     * @timeComplexity O(nlogn) 取决于排序算法复杂度
     * @spaceComplexity O(1)
     */
    public static boolean solve3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {4,2,3};
        System.out.println(checkPossibility(a) + " : " + Arrays.toString(a));

        a = new int[]{4,2,1};
        System.out.println(checkPossibility(a) + " : " + Arrays.toString(a));

        a = new int[]{3,4,2,3};
        System.out.println(checkPossibility(a) + " : " + Arrays.toString(a));

        a = new int[]{2,3,3,2,4};
        System.out.println(checkPossibility(a) + " : " + Arrays.toString(a));
    }

}