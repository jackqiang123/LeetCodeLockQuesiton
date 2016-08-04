// roblem Description:
//
// A 2d grid map of m rows and n columns is initially filled with water.
// We may perform an addLand operation which turns the water at position (row, col) into a land.
// Given a list of positions to operate, count the number of islands after each addLand operation.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
//
// Example:
//
// Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
// Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
//
// 0 0 0
// 0 0 0
// 0 0 0
//
// Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
//
// 1 0 0
// 0 0 0   Number of islands = 1
// 0 0 0
//
// Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
//
// 1 1 0
// 0 0 0   Number of islands = 1
// 0 0 0
//
// Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
//
// 1 1 0
// 0 0 1   Number of islands = 2
// 0 0 0
//
// Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
//
// 1 1 0
// 0 0 1   Number of islands = 3
// 0 1 0
//
// We return the result as an array: [1, 1, 2, 3]
public class Solution{
  int []rootArray;
  public List<Integer> numIslands2(int m, int n, int[][] positions) {
      List<Integer> res = new ArrayList<>();
      int count = 0;
      rootArray = new int[m*n];
      for (int i = 0; i < rootArray.length; i++) rootArray[i]= i;
      boolean [][]visit = new boolean[m][n];
      int []dx = new int[]{1,0,-1,0};
      int []dy = new int[]{0,1,0,-1};
      for (int []land : positions){
        int uc = 0;
        if (visit[land[0]][land[1]]) {
          res.add(count); continue;
        }
        visit[land[0]][land[1]] = true;
        for (int i = 0; i < dx.length; ++i){
          int thisx = land[0] + dx[i];
          int thisy = land[1] + dy[i];

          if (thisx < 0 || thisx >= m || thisy < 0 || thisy >= n || visit[thisx][thisy] == false)
            continue;
          if (union(land[0]*n+land[1], thisx*n+thisy))
            uc++;
        }
        if (uc == 0) res.add(++count);
        else if (uc == 1) res.add(count);
        else if (uc == 2) res.add(--count);
        else if (uc == 3) {
          count -= 2; res.add(count);
        }
        else {
          count -= 3; res.add(count);
        }
      }
      return res;
  }
  private boolean union(int i, int j){
    if (root(i) == root(j)) return false;
    rootArray[root(i)] = root(j);
    return true;
  }
  private int root(int i){
      while(i != rootArray[i]) i = rootArray[i];
      return i;
  }
}
