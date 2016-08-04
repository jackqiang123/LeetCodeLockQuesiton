// Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
//
// "abc" -> "bcd" -> ... -> "xyz"
// Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
//
// For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
// Return:
//
// [
//   ["abc","bcd","xyz"],
//   ["az","ba"],
//   ["acef"],
//   ["a","z"]
// ]
// Note: For the return value, each inner list's elements must follow the lexicographic order.

public class Solution{
    public List<List<String>> groupStrings(String[] strings) {
      List<List<String>> res = new ArrayList<>();
      Map<String, List<String>> map = new HashMap<>();
      for (String s : strings){
        String encode = getCode(s);
        if (map.get(encode) == null) map.put(encode, new ArrayList<String>());
        map.get(encode).add(s);
      }
      for (List<String> value : map.values()){
        Collections.sort(value);
        res.add(value);
      }
      return res;
    }
    private String getCode(String s){
      if (s.length() == 1) return "1";
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < s.length()-1; i++){
        int diff = Math.abs(s.charAt(i+1)-s.charAt(i) + 26)%26;
        res.append(diff).append(':');
      }
      return res.toString();
    }
  }
