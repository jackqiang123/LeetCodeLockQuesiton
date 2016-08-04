// Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
//
// If two nodes are in the same row and column, the order should be from left to right.
//
// Examples:
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
//
//
// return its vertical order traversal as:
//
// [
//   [9],
//   [3,15],
//   [20],
//   [7]
// ]
//
//
//
// Given binary tree [3,9,20,4,5,2,7],
//
//     _3_
//    /   \
//   9    20
//  / \   / \
// 4   5 2   7
//
//
//
// return its vertical order traversal as:
//
// [
//   [4],
//   [9],
//   [3,5,2],
//   [20],
//   [7]
// ]
public class Solution{
    class PositionTreeNode{
      TreeNode node;
      int col; // location of this node
      public PositionTreeNode(TreeNode node, int col){
        this.node = node;
        this.col = col;
      }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();
         if (root == null) return res;
      Map<Integer, List<Integer>> map = new HashMap<>();
      Queue<PositionTreeNode> queue = new LinkedList<>();
      queue.add(new PositionTreeNode(root,0));
      while(!queue.isEmpty()){
        PositionTreeNode cur = queue.remove();
        if (map.get(cur.col) == null) map.put(cur.col, new ArrayList<Integer>());
        map.get(cur.col).add(cur.node.val);
        if (cur.node.left != null) {
          queue.add(new PositionTreeNode(cur.node.left, cur.col-1));
        }
        if (cur.node.right != null){
          queue.add(new PositionTreeNode(cur.node.right, cur.col+1));
        }
      }

      List<Integer> colList = new ArrayList<Integer>(map.keySet());
      Collections.sort(colList);
      for (int i : colList)
        res.add(map.get(i));
      return res;
    }

  }
