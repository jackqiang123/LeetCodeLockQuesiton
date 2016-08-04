// An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
//
// For example, given the following image:
//
// [
//   "0010",
//   "0110",
//   "0100"
// ]
// and x = 0, y = 2,
// Return 6.
public class Solution{
    // consider mapping a 2-d vector into 1-d vector
   public int minArea(char[][] image, int x, int y) {
      int lx = findBound(image, 0, x, true, true);
      int hx = findBound(image, x, image.length - 1, true, false);
      int ly = findBound(image, 0, y, false, true);
      int hy = findBound(image, y, image[0].length - 1, false, false);
      return (hy - ly + 1) * (hx - lx + 1);
   }
   private int findBound(char[][]image, int lo, int hi, boolean isX, boolean checkingLow){
     while(lo < hi){
       int mid = (lo+hi)/2;
       if (checkingLow){
         if (check(image, mid, isX)) hi = mid;
         else lo = mid + 1;
       }
       else {
         if (check(image, mid, isX)) lo = mid + 1;
         else hi = mid;
       }
     }
     if (checkingLow) return lo;
     if (check(image, lo, isX)) return lo;
     return lo-1;
   }
   private boolean check(char[][]image, int x, boolean isX){
     if (isX){
       for (int j = 0; j < image[0].length; j++){
         if (image[x][j] == '1') return true;
       }
       return false;
     }
     else {
       for (int i = 0; i < image.length; i++){
         if (image[i][x] == '1') return true;
       }
       return false;
     }
   }
 }
