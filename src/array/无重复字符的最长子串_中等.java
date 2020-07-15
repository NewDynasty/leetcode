package array;

import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class 无重复字符的最长子串_中等 {

    /**
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return solve2(s);
    }

    /**
     * 1. 暴力求解
     *
     * @timeComplexity O(n ^ 2) 最坏情况
     * @spaceComplexity O(1)
     */
    private static int solve1(String s) {
        // 2,3,1,2,4,3
        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int x = 0;
//            for (int j = i, count = 1; j < nums.length; j++, count++) {
//                x += nums[j];
//                if (x >= s) {
//                    if (max < count) {
//                        max = count;
//                    }
//                }
//            }
//        }
        return max;
    }

    /**
     * 2. hash 通过
     *
     * @timeComplexity O(n ^ 2) 最坏情况
     * @spaceComplexity O(1)
     */
    private static int solve2(String s) {
        // abcabcbb start = 0 end = 0 max = 0 a
        // abcabcbb start = 0 end = 1 max = 1 ab
        // abcabcbb start = 0 end = 2 max = 2 abc
        // abcabcbb start = 0 end = 3 max = 3 abca
        // change
        // abcabcbb start = 2 end = 3 max = 3 ca
        // abcabcbb start = 2 end = 4 max = 3 cab
        // abcabcbb start = 2 end = 5 max = 3 cabc
        // change
        // abcabcbb start = 4 end = 5 max = 3 bc
        // abcabcbb start = 4 end = 6 max = 3 bcb
        // change
        // abcabcbb start = 5 end = 6 max = 3 cb
        // abcabcbb start = 5 end = 7 max = 3 cbb
        // change
        // abcabcbb start = 5 end = 7 max = 3 cbb
        // change
        // abcabcbb start = 6 end = 7 max = 3 bb
        // change
        // abcabcbb start = 6 end = 7 max = 3 bb
        int start = 0, end = 0, max = 0;
        HashSet<Character> set = new HashSet<>();
        do {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                if (set.size() > max) {
                    max = set.size();
                }
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
                if (start == end) {
                    set.add(s.charAt(start));
                    end++;
                }
            }
        } while (start < end && end < s.length());
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("anviaj"));
        System.out.println(lengthOfLongestSubstring("jbpnbwwd"));
        System.out.println(lengthOfLongestSubstring("aab"));
    }

}
