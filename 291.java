//
// Given a pattern and a string str, find if str follows the same pattern.
//
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
//
// Examples:
//
//         pattern = "abab", str = "redblueredblue" should return true.
//         pattern = "aaaa", str = "asdasdasdasd" should return true.
//         pattern = "aabb", str = "xyzabcxzyabc" should return false.
//
// Notes:
// You may assume both pattern and str contains only lowercase letters.
public class Solution{
  Map<Character, String> cToString;
  Map<String, Character> stringToC;
  public boolean wordPatternMatch(String pattern, String str) {
    cToString = new HashMap<>();
    stringToC = new HashMap<>();
    return helper(pattern, 0, str, 0);
  }
  private boolean helper(String pattern, int p, String str, int s){
    if (p >= pattern.length() || s >= str.length()){
      if (p == pattern.length() && s == str.length()) return true;
      else return false;
    }
    else {
      char c = pattern.charAt(p);
      if (cToString.get(c) != null) {
        String target = cToString.get(c);
        if (stringToC.get(target) == null || stringToC.get(target) != c) return false;
        int end = Math.min(target.length() + s, str.length());
        if (!str.substring(s, end).equals(target)) return false;
        if (stringToC.get(target) != c) return false;
        return helper(pattern, p+1, str, end);
      }
      else {
        for (int end = s + 1; end <= str.length(); end++){
          String target = str.substring(s, end);
          if (stringToC.get(target) != null) continue;
          stringToC.put(target, c);
          cToString.put(c,target);
          if (helper(pattern, p + 1, str, end)) return true;
          stringToC.remove(target);
          cToString.remove(c);
        }
        return false;
      }
    }
  }
}
