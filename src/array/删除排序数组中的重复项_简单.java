package array;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class 删除排序数组中的重复项_简单 {

    /**
     * 示例 1:
     *
     * 给定数组 nums = [1,1,2],
     *
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     *
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     *
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public static int solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int firstDuplicationIndex = 1;
        for (int i = 1, duplication = nums[0]; i < nums.length; i++) {
            if (nums[i] != duplication) {
                nums[firstDuplicationIndex] = nums[i];
                duplication = nums[i];
                firstDuplicationIndex++;
            }
        }
        return firstDuplicationIndex;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        System.out.println(solve(a) + " : " + Arrays.toString(a));

        a = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(solve(a) + " : " + Arrays.toString(a));

        a = new int[]{1,2};
        System.out.println(solve(a) + " : " + Arrays.toString(a));
    }

}