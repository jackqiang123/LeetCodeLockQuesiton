// Given a binary tree where all the right nodes are either leaf nodes with a sibling
// (a left node that shares the same parent node) or empty, flip it upside down and turn it into a
//  tree where the original right nodes turned into left leaf nodes. Return the new root.
//
// For example:
// Given a binary tree {1,2,3,4,5},
// 1
// / \
// 2 3
// / \
// 4 5
//
// return the root of the binary tree [4,5,2,#,#,3,1].
// 4
// / \
// 5 2
//   / \
//  3 1
public class Solution{
  // this question is more like a recrusion way of reverse a linkedlist.
  // first reverse the left child. then make the left left point to right, left right point to parent.
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null || root.left == null) return root;
    TreeNode myRoot = root.left;
    TreeNode myLeft = root.right;
    TreeNode myRight = root;
    root.left = null; root.right = null;
    TreeNode newRoot = upsideDownBinaryTree(myRoot);
    myRoot.left = myLeft;
    myRoot.right = root;
    return newRoot;
  }
}
