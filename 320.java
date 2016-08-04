// Write a function to generate the generalized abbreviations of a word.
//
// Example:
// Given word = "word", return the following list (order does not matter):
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
public class Solution {
    List<String> res;
    public List<String> generateAbbreviations(String word) {
      res = new ArrayList<>();
      helper(word, new StringBuilder(), 0, 0);
      return res;
    }
    private void helper(String word, StringBuilder cur, int abbrlen, int start){
      if (start == word.length()){
        if (abbrlen == 0) res.add(cur.toString());
        else {
          int len = cur.length();
          cur.append(abbrlen);
          res.add(cur.toString());
          cur.setLength(len);
        }
      }
      else {
        helper(word, cur, abbrlen + 1, start + 1); // to abbreviations
        int len = cur.length();
        if (abbrlen != 0)
          cur.append(abbrlen);
        cur.append(word.charAt(start));
        helper(word, cur, 0, start + 1);
        cur.setLength(len);
      }
    }
}
