// There is a fence with n posts, each post can be painted with one of the k colors.
//
// You have to paint all the posts such that no more than two adjacent fence posts have the same color.
//
// Return the total number of ways you can paint the fence.
//
// Note: n and k are non-negative integers.

public class Solution {
        public int numWays(int n, int k) {
          if (n == 0 || k == 0) return 0;
          int p3 = 0;
          int p2 = k*k;
          int p1 = k;
          if (n == 1) return p1;
          if (n == 2) return p2;
          for (int i = 3; i <= n; i++){
            p3 = (k-1)*(p1+p2);
            p1 = p2;
            p2 = p3;
          }
          return p3;
        }
}
