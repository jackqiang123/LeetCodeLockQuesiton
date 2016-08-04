// Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
//
// The returned array must be in sorted order.
//
// Expected time complexity: O(n)
//
// Example:
// nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
//
// Result: [3, 9, 15, 33]
//
// nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
//
// Result: [-23, -5, 1, 7]

public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
      int []res = new int[nums.length];
      double mid = -b*1.0/(2*a);
      int lo = 0; int hi = nums.length - 1; int index = 0;
      while(lo <= hi){
        if (Math.abs(nums[lo] - mid) > Math.abs(nums[hi] - mid)) res[index++] = fun(a,b,c,nums[lo++]);
        else res[index++] = fun(a,b,c,nums[hi--]);
      }
      if (res[0] > res[res.length-1]) reverse(res);
      return res;
    }
      private void reverse(int []res){
        int lo = 0;
        int hi = res.length - 1;
        while(lo < hi)
          swap(res, lo++, hi--);
    }
    private void swap(int[]nums, int i, int j){
      int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
    }
    private int fun(int a,int b,int c, int n){
      return a*n*n+b*n+c;
    }
}
