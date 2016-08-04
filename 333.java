// Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
// where largest means subtree with largest number of nodes in it.
//
// Note:
// A subtree must include all of its descendants.
// Here's an example:
//
//     10
//     / \
//    5  15
//   / \   \
//  1   8   7
// The Largest BST Subtree in this case is the highlighted one.
// The return value is the subtree's size, which is 3.
//
//
//
// Hint:
//
// You can recursively use algorithm similar to 98.
// Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
// Follow up:
// Can you figure out ways to solve it with O(n) time complexity?
public class Solution{
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
      max = 0;
      helper(root);
      return max;
    }
    private Cell helper(TreeNode root){
      if (root == null) return new Cell(0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
      Cell leftResult = helper(root.left);
      Cell rightResult = helper(root.right);
      if (leftResult.isBST && rightResult.isBST){
        if (root.val > leftResult.upper && root.val < rightResult.lower) {
          max = Math.max(max, 1+ leftResult.size + rightResult.size);
          return new Cell(1+ leftResult.size + rightResult.size, true, Math.min(root.val, leftResult.lower), Math.max(root.val, rightResult.upper));
        }
      }
      return new Cell(0, false, 0, 0);
    }
    class Cell{
      int size;
      boolean isBST;
      int lower;
      int upper;
      public Cell(int size, boolean isBST, int lower, int upper){
        this.size = size; this.isBST = isBST; this.lower = lower; this.upper = upper;
      }
    }
  }
