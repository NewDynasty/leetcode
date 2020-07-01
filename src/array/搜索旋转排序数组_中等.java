package array;

import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 */
public class 搜索旋转排序数组_中等 {

    /**
     * 示例 1:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     *
     */
    public static int solve(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
            if (i == 0 && target < nums[i]) {
                for (int j = i-1; j != i; j--) {
                    if (j == -1) {
                        j = nums.length - 1;
                    }
                    if (target == nums[j]) {
                        return j;
                    }
                }
                break;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        System.out.println(solve(a, 0));

        a = new int[]{4,5,6,7,0,1,2};
        System.out.println(solve(a, 3));

        a = new int[]{1};
        System.out.println(solve(a, 0));

        a = new int[]{1,3};
        System.out.println(solve(a, 0));

        a = new int[]{1,3};
        System.out.println(solve(a, 2));
    }

}