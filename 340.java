// Given a string, find the length of the longest substring T that contains at most k distinct characters.
//
// For example, Given s = “eceba” and k = 2,
//
// T is "ece" which its length is 3.
public class Solution{
  // another idea is to count the number of chars. forward left pointer one by one, until some count reaches 0
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
      if (k == 0) return 0;
    Map<Character, Integer> map = new HashMap<>();
    int best = 0;
    int i = 0, j = 0;
    while(j < s.length()){
      char c = s.charAt(j);
      if (map.size() < k) {
        if (map.get(c) == null) map.put(c, 1);
        else map.put(c, map.get(c) + 1);
        j++; best = Math.max(j - i, best);
      }
      else if (map.get(c) != null) {
        map.put(c, map.get(c) + 1);
        j++; best = Math.max(j - i, best);
      }
      else {
        while(i < j) {
          char last = s.charAt(i++);
          map.put(last, map.get(last) - 1);
          if (map.get(last) == 0) {map.remove(last); break;}
        }
      }
    }
    return best;
  }
}
