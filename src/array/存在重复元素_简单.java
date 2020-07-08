package array;

import java.util.*;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 */
public class 存在重复元素_简单 {

    /**
     * 示例 1:
     *
     * 输入: [1,2,3,1]
     * 输出: true
     *
     * 示例 2:
     *
     * 输入: [1,2,3,4]
     * 输出: false
     *
     * 示例 3:
     *
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }
        return solve3(nums);
    }

    /**
     * 1. hash 哈希比较
     * @timeComplexity O(n)
     * @spaceComplexity O(n)
     */
    public static boolean solve1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
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
        System.out.println(containsDuplicate(a) + " : " + Arrays.toString(a));

        a = new int[]{1,2,3,4};
        System.out.println(containsDuplicate(a) + " : " + Arrays.toString(a));

        a = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(a) + " : " + Arrays.toString(a));
    }

}