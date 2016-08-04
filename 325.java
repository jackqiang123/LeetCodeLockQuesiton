// Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
//  If there isn't one, return 0 instead.
//
// Example 1:
// Given nums = [1, -1, 5, -2, 3], k = 3,
// return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
//
// Example 2:
// Given nums = [-2, -1, 2, 1], k = 1,
// return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
//
// Follow Up:
// Can you do it in O(n) time?
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      int n = 0;
      int best = 0;
      for (int i = 0; i < nums.length; i++){
        n += nums[i];
        if (map.get(n) == null) map.put(n,i);
        if (n == k) best = i + 1;
      }
      n = 0;
      for (int i = 0; i < nums.length; i++){
        n += nums[i];
        int target = n - k;
        if (map.get(target) != null) best = Math.max(best, i - map.get(target));
      }
      return best;
    }
  }
