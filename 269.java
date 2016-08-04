// There is a new alien language which uses the latin alphabet.
// However, the order among letters are unknown to you. You receive a list of words
// from the dictionary, wherewords are sorted lexicographically by the rules of this new language.
// Derive the order of letters in this language.
//
// For example,
// Given the following words in dictionary,
//
// [
//   "wrt",
//   "wrf",
//   "er",
//   "ett",
//   "rftt"
// ]
// The correct order is: "wertf".
//
// Note:
//
// You may assume all letters are in lowercase.
// If the order is invalid, return an empty string.
// There may be multiple valid order of letters, return any one of them is fine.
public class Solution{
   Map<Character, List<Character>> order;
   Map<Character, Integer> prevCount;
   public String alienOrder(String[] words) {
     if (words.length == 1) return words[0];
     order = new HashMap<>(); // char to next char list
     prevCount = new HashMap<>();
     for (int i = 0; i < words.length- 1; i++){
       getOrder(words[i], words[i+1]);
     }
     Queue<Character> queue = new LinkedList<>();
     for (char c : prevCount.keySet()) {
       if (prevCount.get(c) == 0)
        queue.add(c);
     }
     StringBuilder res = new StringBuilder();
     while(!queue.isEmpty()){
       char cur = queue.remove();
       res.append(cur);
       List<Character> next = order.get(cur);
       if (next != null)
       for (char c : next){
         prevCount.put(c, prevCount.get(c)-1);
         if (prevCount.get(c) == 0){
           queue.add(c);
         }
       }
     }
     if (res.length() == prevCount.size())
      return res.toString();
     return "";
   }

   private void getOrder(String s1, String s2){
     for (int i = 0; i < s1.length(); i++){
       if (prevCount.containsKey(s1.charAt(i)) == false) prevCount.put(s1.charAt(i),0);
     }
     for (int i = 0; i < s2.length(); i++){
         if (prevCount.containsKey(s2.charAt(i)) == false) prevCount.put(s2.charAt(i),0);
       }
     for (int i = 0; i < Math.min(s1.length(),s2.length()); i++){
       if (s1.charAt(i) != s2.charAt(i)){
         if(order.get(s1.charAt(i)) == null) order.put(s1.charAt(i), new ArrayList<Character>());
         order.get(s1.charAt(i)).add(s2.charAt(i));
         prevCount.put(s2.charAt(i), prevCount.get(s2.charAt(i))+1);
         break;
       }
     }

   }
 }
