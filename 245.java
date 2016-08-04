// This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
//
// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
// word1 and word2 may be the same and they represent two individual words in the list.
//
// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
// Given word1 = “makes”, word2 = “coding”, return 1.
// Given word1 = "makes", word2 = "makes", return 3.
//
// Note:
// You may assume word1 and word2 are both in the list.
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
      int min = words.length;
      int i = 0, j = 0;// i is for w1, j is for w2
      int len = words.length;
      while(i < len && j < len){
        while(i < len && !word1.equals(words[i])) i++;
        while(j < len && !word2.equals(words[j])) j++;
        if (i != j && Math.abs(i-j) < min && i < len && j < len) min = Math.abs(i-j);
        if (i < j) i++;
        else j++;
      }
      return min;
    }
  }
