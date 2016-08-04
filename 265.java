// here are a row of n houses, each house can be painted with one of the k colors.
// The cost of painting each house with a certain color is different.
// You have to paint all the houses such that no two adjacent houses have the same color.
//
// The cost of painting each house with a certain color is represented by a n x k cost matrix.
// For example, costs[0][0] is the cost of painting house 0 with color 0;
// costs[1][2] is the cost of painting house 1 with color 2, and so on...
// Find the minimum cost to paint all houses.
//
// Note:
// All costs are positive integers.
//
// Follow up:
// Could you solve it in O(nk) runtime?
public class Solution {
    public int minCostII(int[][] costs) {
      int h = costs.length;
      if (h == 0) return 0;
      int w = costs[0].length;
      int [][]dp = new int[h][w];
      int lastMinIndex = 0; int secMinIndex = 0;
      for (int i = 0; i < h; i++){
        for (int j = 0; j < w; j++){
          if(i == 0) dp[i][j] = costs[i][j];
          else {
            if (j == lastMinIndex) {
              dp[i][j] = dp[i-1][secMinIndex] + costs[i][j];
            }
            else {
              dp[i][j] = dp[i-1][lastMinIndex] + costs[i][j];
            }
          }
        }
        lastMinIndex = 0;
        for (int j = 0; j < w; j++){
          if (dp[i][lastMinIndex]>dp[i][j]) lastMinIndex = j;
        }

        secMinIndex = lastMinIndex == 0 ? 1 : 0;
        for (int j = 0; j < w && secMinIndex < w; j++){
          if (dp[i][secMinIndex] > dp[i][j] && j != lastMinIndex) secMinIndex = j;
        }
      }
      int best = Integer.MAX_VALUE;
      for (int i : dp[h-1]){
        best = Math.min(best, i);
      }
      return best;
    }
  }
