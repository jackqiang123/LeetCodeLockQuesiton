// Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
//
// Note: If the given node has no in-order successor in the tree, return null.
public class Solution{
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (p.right != null) {
      p = p.right;
      while(p.left != null) p = p.left;
      return p;
    }
    else {
      TreeNode res = null;
      while(true){
        if (root.val < p.val)
          root = root.right;
        else if (root.val > p.val)
        { res = root;  root = root.left;}
        else break;
      }
      return res;
    }
  }
}
