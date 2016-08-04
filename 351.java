// Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
//
// Rules for a valid pattern:
//
// Each pattern must connect at least m keys and at most n keys.
// All the keys must be distinct.
// If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
// The order of keys used matters.
//
//
//
//
// Explanation:
//
// | 1 | 2 | 3 |
// | 4 | 5 | 6 |
// | 7 | 8 | 9 |
//
//
// Invalid move: 4 - 1 - 3 - 6
// Line 1 - 3 passes through key 2 which had not been selected in the pattern.
//
// Invalid move: 4 - 1 - 9 - 2
// Line 1 - 9 passes through key 5 which had not been selected in the pattern.
//
// Valid move: 2 - 4 - 1 - 3 - 6
// Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
//
// Valid move: 6 - 5 - 4 - 1 - 9 - 2
// Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
//
// Example:
// Given m = 1, n = 1, return 9.
//
// Credits:
// Special thanks to @elmirap for adding this problem and creating all test cases.
public class Solution {
    int [][]condPaths = new int [10][10];
    {
      condPaths[1][7] = 4;
      condPaths[1][3] = 2;
      condPaths[1][9] = 5;
      condPaths[2][8] = 5;
      condPaths[3][1] = 2;
      condPaths[3][9] = 6;
      condPaths[3][7] = 5;
      condPaths[4][6] = 5;
      condPaths[6][4] = 5;
      condPaths[7][1] = 4;
      condPaths[7][9] = 8;
      condPaths[7][3] = 5;
      condPaths[8][2] = 5;
      condPaths[9][7] = 8;
      condPaths[9][3] = 6;
      condPaths[9][1] = 5;
    }
    int res = 0;
    boolean[]visit;
    public int numberOfPatterns(int m, int n) {
      res = 0;
      for (int i = 1; i <= 9; i++){
        visit = new boolean[10];
        visit[0] = true;
        visit[i] = true;
        helper(i, 1, m, n);
      }
      return res;
    }
    private void helper(int last, int len, int lower, int upper){
      if (len >= lower && len <= upper) {res++;}
      if (len > upper) return;
      for (int i = 1; i <= 9; i++){
        if(visit[i]) continue;
        if (!visit[condPaths[last][i]]) continue;
        visit[i] = true;
        helper(i, len + 1, lower, upper);
        visit[i] = false;
      }
    }
}
