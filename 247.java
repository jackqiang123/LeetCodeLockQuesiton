// A strobogrammatic number is a number that looks the same when rotated 180
// degrees (looked at upside down).
//
// Find all strobogrammatic numbers that are of length = n.
//
// For example,
// Given n = 2, return ["11","69","88","96"].
//
// Hint:
//
// Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
public class Solution{
    Map<Character, Character> map = new HashMap<>();
    {
      map.put('0','0');map.put('1','1');map.put('8','8');
      map.put('6','9');map.put('9','6');
    }
    int targetLen = 0;
    public List<String> findStrobogrammatic(int n){
      targetLen = Math.max(targetLen, n);
      List<String> res = new ArrayList<String>();
      if (n == 0) return res;
      else if (n == 1)
      {
        res.add("0");res.add("1");res.add("8");
        return res;
      }
      else if (n == 2){
        if (n != targetLen)
        res.add("00");
        res.add("11");res.add("88");res.add("69");res.add("96");
        return res;
      }
      else {
        List<String> last = findStrobogrammatic(n-2);
        for (String s : last){
          for (char c : map.keySet()){
            if (n == targetLen && c == '0') continue;
            String news = String.valueOf(c) + s + String.valueOf(map.get(c));
            res.add(news);
          }
        }
        return res;
      }
    }
  }
