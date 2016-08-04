// Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
//
// Example 1:
// Given points = [[1,1],[-1,1]], return true.
//
// Example 2:
// Given points = [[1,1],[-1,-1]], return false.
//
// Follow up:
// Could you do better than O(n2)?
//
// Hint:
//
// Find the smallest and largest x-value for all points.
// If there is a line then it should be at y = (minX + maxX) / 2.
// For each point, make sure that it has a reflected point in the opposite side.
public class Solution {
  public boolean isReflected(int[][] points) {
    if (points.length == 0) return true;
    int min = points[0][0];
    int max = min;
    int [][]rPoint = new int[points.length][2];
    Map<String, Integer> map = new HashMap<>();
    for (int[]p:points){
      min = Math.min(min, p[0]);
      max = Math.max(max, p[0]);
      String code = p[0] + "," + p[1];
      if (map.get(code) == null) map.put(code,1);
      else map.put(code, map.get(code)+1);
    }
    int sum = min + max;
    int i = 0;
    for (int[]p:points){
      String code = (sum - p[0]) + "," + p[1];
      if (map.get(code) == null) return false;
      map.put(code, map.get(code)-1);
      if (map.get(code) == 0) map.remove(code);
    }
    return map.size() == 0;
  }
}
