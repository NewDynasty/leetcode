package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 */
public class 存在重复元素iii_中等 {

    /**
     * 示例 1:
     *
     * 输入: nums = [1,2,3,1], k = 3, t = 0
     * 输出: true
     * 示例 2:
     *
     * 输入: nums = [1,0,1,1], k = 1, t = 2
     * 输出: true
     * 示例 3:
     *
     * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
     * 输出: false
     *
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }
        return solve2(nums, k, t);
    }

    /**
     * 1. hash 哈希比较
     * @timeComplexity O(n)
     * @spaceComplexity O(n)
     */
    public static boolean solve1(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer x = null;
        for (int i = 0; i < nums.length; i++) {
            if ((x = map.get(nums[i])) != null && Math.abs(x - i) <= k && Math.abs(i - x) <= t) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
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
        int[] a = {1,2,3,1};
        System.out.println(containsNearbyAlmostDuplicate(a, 3, 0) + " : " + Arrays.toString(a));

        a = new int[]{1,0,1,1};
        System.out.println(containsNearbyAlmostDuplicate(a, 1, 2) + " : " + Arrays.toString(a));

        a = new int[]{1,5,9,1,5,9};
        System.out.println(containsNearbyAlmostDuplicate(a, 2, 3) + " : " + Arrays.toString(a));

        a = new int[]{-1,2147483647};
        System.out.println(containsNearbyAlmostDuplicate(a, 1, 2147483647) + " : " + Arrays.toString(a));

        a = new int[]{-2147483647,2147483647};
        System.out.println(containsNearbyAlmostDuplicate(a, 1, 2147483647) + " : " + Arrays.toString(a));
    }

}