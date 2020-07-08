package array;

import java.util.*;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 */
public class 存在重复元素ii_简单 {

    /**
     * 示例 1:
     *
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * 示例 2:
     *
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     * 示例 3:
     *
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     *
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }
        return solve1(nums, k);
    }

    /**
     * 1. hash 哈希比较
     * @timeComplexity O(n)
     * @spaceComplexity O(n)
     */
    public static boolean solve1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer x = null;
        for (int i = 0; i < nums.length; i++) {
            if ((x = map.get(nums[i])) != null && Math.abs(x - i) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    /**
     * 2. bubbling compare 冒泡比较（必超时）
     * @timeComplexity O(n^2)
     * @spaceComplexity O(1)
     */
    public static boolean solve2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
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
        int[] a = {1,2,3,1};
        System.out.println(containsNearbyDuplicate(a, 3) + " : " + Arrays.toString(a));

        a = new int[]{1,0,1,1};
        System.out.println(containsNearbyDuplicate(a, 1) + " : " + Arrays.toString(a));

        a = new int[]{1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(a, 2) + " : " + Arrays.toString(a));
    }

}