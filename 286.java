// Walls and Gates
//
// You are given a m x n 2D grid initialized with these three possible values.
//
//     -1 - A wall or an obstacle.
//     0 - A gate.
//     INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the
//  distance to a gate is less than 2147483647.
//
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
//
// For example, given the 2D grid:
//
// INF  -1  0  INF
// INF INF INF  -1
// INF  -1 INF  -1
//   0  -1 INF INF
//
// After running your function, the 2D grid should be:
//
//   3  -1   0   1
//   2   2   1  -1
//   1  -1   2  -1
//   0  -1   3   4
public class Solution {
    int h;
    int w;
    public void wallsAndGates(int[][] rooms) {
      h = rooms.length;
      if (h == 0) return;
      w = rooms[0].length;
      int dx[] = new int[]{-1,0,1,0};
      int dy[] = new int[]{0,-1,0,1};
      Queue<Integer> queue = new LinkedList<>();
      for (int i = 0; i < h; i++)
        for (int j = 0; j < w; j++)
          if (rooms[i][j] == 0) queue.add(i*w+j);
      int curDis = 0;
      while(!queue.isEmpty()){
        curDis++;
        int qsize = queue.size();
        for (int i = 0; i < qsize; i++){
          int cur = queue.remove();
          int curx = cur/w;
          int cury = cur%w;
          for (int counter = 0; counter < dx.length; counter++){
            int newx = curx + dx[counter];
            int newy = cury + dy[counter];
            if (newx >= 0 && newx < h && newy >= 0 && newy < w) {
              if (rooms[newx][newy] == Integer.MAX_VALUE){
                rooms[newx][newy] = curDis;
                queue.add(newx*w+newy);
              }
            }
          }
        }
      }
    }
}
