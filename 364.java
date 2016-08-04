// Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
//
// Each element is either an integer, or a list -- whose elements may also be integers or other lists.
//
// Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
//
// Example 1:
// Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)
//
// Example 2:
// Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 public class Solution {
     public int depthSumInverse(List<NestedInteger> nestedList) {
       int depth = findDepth(nestedList);
       int sum = 0;
       for (NestedInteger ni : nestedList){
         sum += helper(ni, depth);
       }
       return sum;
     }
     private int findDepth(List<NestedInteger> nestedList){
       int d = 0;
       for (NestedInteger n : nestedList){
         d = Math.max(d, dhelper(n));
       }
       return d;
     }
     private int dhelper(NestedInteger n){
       if (n.isInteger()) return 1;
       int d = 1;
       for (NestedInteger ni : n.getList()){
         d = Math.max(d, 1 + dhelper(ni));
       }
       return d;
     }

     private int helper(NestedInteger ni, int depth){
       if (ni.isInteger()) return ni.getInteger()*depth;
       int sum = 0;
       for (NestedInteger n : ni.getList()){
         sum += helper(n, depth-1);
       }
       return sum;
     }
   }
