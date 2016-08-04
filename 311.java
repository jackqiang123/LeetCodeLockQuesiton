// Given two sparse matrices A and B, return the result of AB.
//
// You may assume that A's column number is equal to B's row number.
//
// Example:
//
// A = [
//   [ 1, 0, 0],
//   [-1, 0, 3]
// ]
//
// B = [
//   [ 7, 0, 0 ],
//   [ 0, 0, 0 ],
//   [ 0, 0, 1 ]
// ]
//
//
//      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
// AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//                   | 0 0 1 |
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
      int ha = A.length;
      int w = B.length;
      int wb = B[0].length;
      int [][]res = new int[ha][wb];
      for (int i = 0; i < A.length; i++){
        for (int j = 0; j < A[0].length; j++){
          if (A[i][j] != 0){
            for (int l = 0; l < B[0].length; l++){
              res[i][l] += A[i][j]*B[j][l];
            }
          }
        }
      }
      return res;
    }
}
