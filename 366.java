// Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is empty.
//
// Example:
// Given binary tree
//           1
//          / \
//         2   3
//        / \
//       4   5
// Returns [4, 5, 3], [2], [1].
//
// Explanation:
// 1. Remove the leaves [4, 5, 3] from the tree
//
//           1
//          /
//         2
// 2. Remove the leaf [2] from the tree
//
//           1
// 3. Remove the leaf [1] from the tree
//
//           []
// Returns [4, 5, 3], [2], [1].
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        helper(root);
        return res;
    }
    private int helper(TreeNode node){
        if(null==node)  return -1;
        int height= 1 + Math.max(helper(node.left), helper(node.right));
        if(res.size()<height+1)  res.add(new ArrayList<Integer>());
        res.get(height).add(node.val);
        // if need to actually remove the leaves, uncomment next line
        // node.left = node.right = null;
        return height;
    }
}
