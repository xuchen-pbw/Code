package leetcode.array;
/*longest-consecutive-sequence
        Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
        For example,
        Given[100, 4, 200, 1, 3, 2],
        The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
        Your algorithm should run in O(n) complexity.*/

import java.util.HashMap;
//乱序数组中，求最长连续子序列
public class LongestConsecutive {
    public int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }
}
