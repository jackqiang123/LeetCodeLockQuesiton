// Given a non-empty binary search tree and a target value,
// find the value in the BST that is closest to the target.
//
// Note:
//
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.
public class Solution{
  public int closestValue(TreeNode root, double target) {
    int best = root.val;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    TreeNode cur = root;
    while(cur != null){
      if (Math.abs(best - target) > Math.abs(cur.val - target)) best = cur.val;
      if (cur.val < target){
        cur = cur.right;
      }
      else if (cur.val > target){
        cur = cur.left;
      }
      else return cur.val;
    }
    return best;
  }
}
