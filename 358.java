// Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.
//
// All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
//
// Example 1:
// str = "aabbcc", k = 3
//
// Result: "abcabc"
//
// The same letters are at least distance 3 from each other.
// Example 2:
// str = "aaabc", k = 3
//
// Answer: ""
//
// It is not possible to rearrange the string.
// Example 3:
// str = "aaadbbcc", k = 2
//
// Answer: "abacabcd"
//
// Another possible answer is: "abcabcda"
//
// The same letters are at least distance 2 from each other.
// Credits:
// refer to another repo for another provable solution.
// for this one, i do not know how to prove the correctness.
public class Solution {
    public String rearrangeString(String str, int k) {
      if (k == 0) return str;
      int [] count = new int[26];
      for (int i = 0; i < str.length(); i++){
        count[str.charAt(i) - 'a']++;
      }
      int []lastPosition = new int[26];
      Arrays.fill(lastPosition, -k);
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < str.length(); i++){
        int bestCan = findcand(count, lastPosition, i, k);
        if (bestCan == -1) return "";
        res.append((char)(bestCan + 'a'));
        lastPosition[bestCan] = i;
      }
      return res.toString();
    }
    private int findcand(int []count, int[]lastPosition, int cur, int k){
      int index = -1;
      int max = -1;
      for (int i = 0; i < count.length; i++){
        if (count[i] > max && cur - lastPosition[i] >= k)
          inedx = i;
      }
      return index;
    }
  }
