// Problem Description:
//
// You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
//
// Write a function to determine if the starting player can guarantee a win.
//
// For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
//
// Follow up:
// Derive your algorithm's runtime complexity.

public class Solution {
 public boolean canWin(String s) {
   List<String> next = generatePossibleNextMoves(s);
   if (next.size() == 0) return false;
   for (String ss : next){
     if (!canWin(ss)) return true;
   }
   return false;
 }
 private List<String> generatePossibleNextMoves(String s) {
   char [] sarray = s.toCharArray();
   List<String> res = new ArrayList<>();
   for (int i = 1; i < sarray.length; i++){
     if (sarray[i-1] == '+' && sarray[i] == '+'){
       sarray[i-1] = '-'; sarray[i] = '-';
       res.add(new String(sarray));
       sarray[i-1] = '+'; sarray[i] = '+';
     }
   }
   return res;
 }
}
