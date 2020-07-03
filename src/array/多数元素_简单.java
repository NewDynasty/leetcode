package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 链接：https://leetcode-cn.com/problems/majority-element
 */
public class 多数元素_简单 {

    /**
     * 示例 1:
     *
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     */
    public static int majorityElement(int[] nums) {
        // n >= 3
        int maxNum = 0, max = 0;
        Integer current;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            current = map.get(nums[i]);
            if (current != null) {
                current++;
                if (current> max) {
                    max = current;
                    maxNum = nums[i];
                }
                map.put(nums[i], current);
            } else {
                if (max == 0) {
                    max = 1;
                    maxNum = nums[i];
                }
                map.put(nums[i], 1);
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] a = {3,2,3};
        System.out.println(majorityElement(a) + " : " + Arrays.toString(a));

        a = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(a) + " : " + Arrays.toString(a));

        a = new int[]{8,8,7,7,7};
        System.out.println(majorityElement(a) + " : " + Arrays.toString(a));
    }
}
