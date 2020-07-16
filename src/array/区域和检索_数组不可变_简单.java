package array;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable/
 */
public class 区域和检索_数组不可变_简单 {

    static class NumArray {

        int[] nums;

        /**
         * 示例：
         *
         * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
         *
         * sumRange(0, 2) -> 1
         * sumRange(2, 5) -> -1
         * sumRange(0, 5) -> -3
         * 说明:
         *
         * 你可以假设数组不可变。
         * 会多次调用 sumRange 方法。
         */
        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (; i <= j; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[] {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
