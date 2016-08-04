// Given a binary tree, find the length of the longest consecutive sequence path.
//
// The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
//
// For example,
//
//    1
//     \
//      3
//     / \
//    2   4
//         \
//          5
//
// Longest consecutive sequence path is 3-4-5, so return 3.
//
//    2
//     \
//      3
//     /
//    2
//   /
//  1
//
// Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

// this is a bottom up solutin. we can also have a top-down solution.
public class Solution {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
      helper(root); // must include root
      return max;
    }
    private int helper(TreeNode root){
      if (root == null) return 0;
      int res = 1;
      if (root.left != null && root.val + 1 == root.left.val)
        res = 1 + helper(root.left);
      else helper(root.left);

      if (root.right != null && root.val + 1 == root.right.val)
        res = Math.max(res, 1 + helper(root.right));
      else helper(root.right);
      max = Math.max(max, res);
      return res;
    }
  }
