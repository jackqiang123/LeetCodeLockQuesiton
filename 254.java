// Numbers can be regarded as product of its factors. For example,
//
// 8 = 2 x 2 x 2;
//   = 2 x 4.
// Write a function that takes an integer n and return all possible combinations of its factors.
//
// Note:
//
// Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
// You may assume that n is always positive.
// Factors should be greater than 1 and less than n.
//
//
// Examples:
// input: 1
// output:
//
// []
// input: 37
// output:
//
// []
// input: 12
// output:
//
// [
//   [2, 6],
//   [2, 2, 3],
//   [3, 4]
// ]
// input: 32
// output:
//
// [
//   [2, 16],
//   [2, 2, 8],
//   [2, 2, 2, 4],
//   [2, 2, 2, 2, 2],
//   [2, 4, 4],
//   [4, 8]
// ]
public class Solution {
	int num = 0;
	public List<List<Integer>> getFactors(int n) {
		this.num = n;
		return helper(n, 2);// split n with factor, factor within lower bound
	}

  private List<List<Integer>> helper(int n, int lower){
     List<List<Integer>> res = new ArrayList<>();
     if (n < lower) return res;
     if (n != num)  // do not split this number, do not conduct if it is the number itself
      res.add(Arrays.asList(n));
     for (int i = lower; i <= n; i++) {// split the number
        if (n%i!=0)  continue;
        List<List<Integer>> cur = helper(n/i, i);
        for (List<Integer> ls : cur) {
          List<Integer> temp = new ArrayList<Integer>(ls);
          temp.add(0, i);
          res.add(temp);
        }
     }
     return res;
   }
}
