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
   Map<Character, List<Character>> order;// this order shall be obtained by compare two adjenct words
   // my inital idea is to compare all chars at the same time. which leads to very complexity codes
   // in fact, we can extract every pair of words.  this will be sufficient
   // the order is key is prev, list is next nodes
   public String alienOrder(List<String> words) {
