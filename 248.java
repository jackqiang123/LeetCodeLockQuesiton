// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
// Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
public class Solution{
      public int strobogrammaticInRange(String low, String high){
        if (low.compareTo(high) == 1) return 0;
        int lowbit = low.length();
        int highbit = high.length();
        int res = 0;
        for (int i = low; i <= high; i++){
          List<String> cur = findStrobogrammatic(i);
          for (String s : cur){
            if (s.length() == lowbit && s.compareTo(low) < 0) continue;
            if (s.length() == highbit && s.compareTo(high) > 0) continue;
            res++;
          }
        }
        return res;
      }

      Map<Character, Character> map = new HashMap<>();
      {map.put('0','0');map.put('1','1');map.put('8','8');
      map.put('6','9');map.put('9','6');}
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
