
    // A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
    //
    // For example, given three people living at (0,0), (0,4), and (2,2):
    //
    // 1 - 0 - 0 - 0 - 1
    // |   |   |   |   |
    // 0 - 0 - 0 - 0 - 0
    // |   |   |   |   |
    // 0 - 0 - 1 - 0 - 0
    //
    // The point (0,2) is an ideal meeting point, as the total travel
    // distance of 2+2+2=6 is minimal. So return 6.

public class Solution {
        public int minTotalDistance(int[][] grid) {
          List<Integer> index = new ArrayList<Integer>();
          int h = grid.length;
          if (h == 0) return 0;
          int w = grid[0].length;
          for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
              if (grid[i][j] == 1) index.add(i);
            }
          }
          int sum = getDis(index);
          index = new ArrayList<Integer>();
          for (int j = 0; j < w; j++){
            for (int i = 0; i < h; i++){
              if (grid[i][j] == 1) index.add(j);
            }
          }
          return sum + getDis(index);
        }
        private int getDis(List<Integer> index){
          int size = index.size();
          int lo = 0; int hi = size - 1;
          int res = 0;
          while(lo < hi){
            res += index.get(hi--) - index.get(lo++);
          }
          return res;
        }
      }
