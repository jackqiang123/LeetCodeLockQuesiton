// Problem Description:
//
// Given a non-empty binary search tree and a target value,
// find k values in the BST that are closest to the target.
//
// Note:
//
//     Given target value is a floating point.
//     You may assume k is always valid, that is: k ≤ total nodes.
//     You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
// Follow up:
// Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
//
// Hint:
//
//     Consider implement these two helper functions:
//         getPredecessor(N), which returns the next smaller node to N.
//         getSuccessor(N), which returns the next larger node to N.
//     Try to assume that each node has a parent pointer, it makes the problem much easier.
//     Without parent pointer we just need to keep track of the path from the root to the current
//     node using a stack.
//     You would need two stacks to track the path in finding predecessor and successor node separately.
public class Solution{
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
      List<Integer> res = new ArrayList<>();
      Stack<TreeNode> prev = new Stack<>();
      Stack<TreeNode> next = new Stack<>();
      while(root != null) {
        if (root.val < target) {
          prev.push(root);
          root = root.right;
        }
        else {
          next.push(root);
          root = root.left;
        }
      }
      for (int i = 0; i < k; i++){
        if (!prev.isEmpty() && !next.isEmpty()){
          if ((target-prev.peek().val) < (next.peek().val-target)){
            res.add(prev.peek().val);
            removeElement(prev,true);
          }
          else {
            res.add(next.peek().val);
            removeElement(next,false);
          }
        }
        else if (!prev.isEmpty()){
          res.add(prev.peek().val);
          removeElement(prev,true);
        }
        else {
          res.add(next.peek().val);
          removeElement(next,false);
        }
      }
      return res;
    }
    private void removeElement(Stack<TreeNode> stack, boolean isPrev){
      TreeNode cur = stack.pop();
      if (isPrev) cur = cur.left;
      else cur = cur.right;
      while(cur != null){
          stack.push(cur);
        if (isPrev) cur = cur.right;
        else cur = cur.left;
      }
    }
  }
