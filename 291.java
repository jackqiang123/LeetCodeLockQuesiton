/ Problem Description:
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
