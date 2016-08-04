// You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
//
// Each 0 marks an empty land which you can pass by freely.
// Each 1 marks a building which you cannot pass through.
// Each 2 marks an obstacle which you cannot pass through.
// For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
//
// 1 - 0 - 2 - 0 - 1
// |   |   |   |   |
// 0 - 0 - 0 - 0 - 0
// |   |   |   |   |
// 0 - 0 - 1 - 0 - 0
// The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
//
// Note:
// There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
public class Solution{
  public int shortestDistance(int[][] grid) {
    int h = grid.length;
    if (h == 0) return 0;
    int w = grid[0].length;
    int [][]dis = new int[h][w];
    int [][]reach = new int[h][w];
    int []dx = new int[]{0,1,0,-1};
    int []dy = new int[]{1,0,-1,0};
    int bcount = 0;
    for (int i = 0; i < h; i++){
      for (int j = 0; j < w; j++){
        if (grid[i][j] == 1){
          bcount++;
          Queue<Integer> queue = new LinkedList<Integer>();
          boolean visit[][] = new boolean[h][w];
          queue.add(i*w+j);
          int d = 0;
          while(!queue.isEmpty()){
            int qsize = queue.size(); d++;
            for (int index = 0; index < qsize; index++){
              int cur = queue.remove();
              int curx = cur/w;
              int cury = cur%w;
              for (int l = 0; l < dx.length; l++){
                int nx = curx + dx[l];
                int ny = cury + dy[l];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || visit[nx][ny]) continue;
                if(grid[nx][ny] != 0) continue;
                visit[nx][ny] = true;
                dis[nx][ny] += d;
                reach[nx][ny]++;
                queue.add(nx*w+ny);
              }
            }
          }
        }
      }
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < h; i++)
      for (int j = 0; j < w; j++)
    {    if (grid[i][j] == 0)
        {
            if (reach[i][j] != bcount) continue;
            res = Math.min(res, dis[i][j]);

        }

    }

    return res == Integer.MAX_VALUE ? -1 : res;
  }
}
