// Given an array of integers that is already sorted in ascending order,
// find two numbers such that they add up to a specific target number.
//
// The function twoSum should return indices of the two numbers such that
// they add up to the target, where index1 must be less than index2.
// Please note that your returned answers (both index1 and index2) are not zero-based.
//
// You may assume that each input would have exactly one solution.
public class Solution{
  public int[] twoSum(int []nums, int target){
    int i = 0; int j = nums.length - 1;
    while(i < j){
      if (nums[i] + nums[j] > target) {
        j--;
      }
      else if (nums[i] + nums[j] < target) {
        i++;
      }
      else {
        return new int[]{1+i,1+j};
      }
    }
    return null;
  }
}
