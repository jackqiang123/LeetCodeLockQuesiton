// Given a string, find the length of the longest substring T that contains at most k distinct characters.
//
// For example, Given s = “eceba” and k = 2,
//
// T is "ece" which its length is 3.
public class Solution{
  // another idea is to count the number of chars. forward left pointer one by one, until some count reaches 0
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
