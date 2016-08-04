// Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
//
// You may assume each number in the sequence is unique.
//
// Follow up: Could you do it using only constant space complexity?
public class Solution {
public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int lower = Integer.MIN_VALUE;
        for (int i : preorder) {
                if (lower > i) return false;
                while(!stack.isEmpty() && stack.peek() < i) {lower = stack.pop(); }
                stack.push(i);
        }
        return true;
}
}
