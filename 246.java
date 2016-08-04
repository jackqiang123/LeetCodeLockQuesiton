// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
// Write a function to determine if a number is strobogrammatic. The number is represented as a string.
public class Solution{
  Map<Character, Character> map = new HashMap<>();
  {map.put('0','0');map.put('1','1');map.put('8','8');
  map.put('6','9');map.put('9','6');}
  public boolean isStrobogrammatic(String n){
    int len = n.length();
    int i = 0, j = len - 1;
    while(i <= j){
      if (map.get(n.charAt(i)) == null) return false;
      if (map.get(n.charAt(i)) != n.charAt(j)) return false;
      i++; j--;
    }
    return true;
  }
}
