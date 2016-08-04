// Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
// For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
public class Solution {
	    public List<String> findMissingRanges(int[] nums, int start, int end) {
				List<String> res = new ArrayList<>();
				int len = nums.length;
				if (len == 0) {
					res.add(helper(start,end));
					return res;
				}
				int last = start-1;
				for (int i : nums){
						if (last + 1 < i)
							res.add(helper(last+1, i-1));
						last = i;
				}
				if (nums[len-1]!=end){
					last = nums[len - 1];
					res.add(helper(nums[len-1]+1, end));
				}
				return res;
				}
      private String helper(int i, int j){
				if (i == j) return String.valueOf(i);
				return i+"->"+j;
			}
    }
