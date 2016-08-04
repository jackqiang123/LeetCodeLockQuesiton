// Given a string s, return all the palindromic permutations (without duplicates) of it.
// Return an empty list if no palindromic permutation could be form.
//
// For example:
//
// Given s = "aabb", return ["abba", "baab"].
//
// Given s = "abc", return [].
//
// Hint:
//
// If a palindromic permutation exists, we just need to generate the first half of the string.
// To generate all distinct permutations of a (half of) string, use a similar approach from:
// Permutations II or Next Permutation.
public class Solution{
  int []count;
  List<String> res;
  String median = "";
  int len = 0;
  public List<String> generatePalindromes(String s) {
    res = new ArrayList<>();
    count = new int[256];
    for (int i = 0; i < s.length(); i++)
      count[s.charAt(i)]++;
    int odd = 0;
    for (int i = 0; i < count.length; i++)
    {
      if (count[i]%2==1){
        odd++; median = String.valueOf((char)i);
      }
      count[i] /= 2;
      len += count[i];
    }
    if (odd > 1) return res;
    dfs(new StringBuilder());
    return res;
  }
  private void dfs(StringBuilder sb){
    if (sb.length() == len){
      res.add(getResult(sb));
    }
    else {
      for (int i = 0; i < count.length; i++){
        if (count[i] > 0){
          count[i]--;
          sb.append((char)i);
          dfs(sb);
          count[i]++;
          sb.deleteCharAt(sb.length()-1);
        }
      }
    }
  }
  private String getResult(StringBuilder sb){
    String res = sb.toString() + median;
    res = res+sb.reverse().toString();
    sb.reverse();
    return res;
  }
}
