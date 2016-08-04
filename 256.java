// There are a row of n houses, each house can be painted with one of the three colors:
// red, blue or green.
// The cost of painting each house with a certain color is different.
// You have to paint all the houses such that no two
// adjacent houses have the same color.
// The cost of painting each house with a certain color is represented by
// a n x 3 cost matrix.
// For example, costs[0][0] is the cost of painting house 0 with color red;
// costs[1][2] is the cost of painting house
// 1 with color green, and so on... Find the minimum cost to paint all houses.
// Note: All costs are positive integers.
public class Solution {
  public int minCost(int[][] costs) {
    int len = costs.length;
    if (len == 0) return 0;
    int [][]dp = new int[len][3];
    for (int i = 0; i < len; i++){
      for (int j = 0; j < 3; j++){
        if (i == 0) {
          dp[i][j] = costs[i][j];
        }
        else {
          dp[i][j] = Integer.MAX_VALUE;
          for (int l = 0; l < 3; l++){
            if (l == j) continue;
            dp[i][j] = Math.min(dp[i][j], costs[i][j] + dp[i-1][l]);
          }
        }
      }
    }
    return Math.min(Math.min(dp[len-1][1],dp[len-1][0]), dp[len-1][2]);
  }
}
