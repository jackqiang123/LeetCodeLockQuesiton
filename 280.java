//
//
// Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
//
// For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
public class Solution {
    public void wiggleSort(int[] nums) {
      int len = nums.length;
      if (len <= 1) return;
      for (int i = 1; i < len; i++){
        if (i%2==1){
          if (nums[i] > nums[i-1]) continue;
          else swap(nums,i,i-1);
        }
        else {
          if (nums[i] < nums[i-1]) continue;
          else swap(nums,i,i-1);
        }
      }
    }
    private void swap(int[]nums, int i, int j){
      int t = nums[i];
      nums[i] = nums[j];
      nums[j] = t;
    }
  }
