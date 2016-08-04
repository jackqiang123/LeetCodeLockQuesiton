// Given a binary tree, count the number of uni-value subtrees.
//
// A Uni-value subtree means all nodes of the subtree have the same value.
//
// For example:
// Given binary tree,
//               5
//              / \
//             1   5
//            / \   \
//           5   5   5
// return 4.
public class Solution {
    // a linear solution to node. each node will be visit once, similiar like find depth of the tree
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
      helper(root);
      return count;
    }
    private boolean helper(TreeNode root){
        if (root == null) return true;
        boolean leftTrue = helper(root.left);
        boolean rightTrue = helper(root.right);
        if (leftTrue && rightTrue){
          if ((root.left == null || root.val == root.left.val) && (root.right == null || root.val == root.right.val)) {
            count++; return true;
          }
          else return false;
        }
        else return false;
    }
  }
