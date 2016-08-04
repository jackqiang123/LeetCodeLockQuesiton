// An abbreviation of a word follows the form <first letter><number><last letter>.
// Below are some examples of word abbreviations:
//
// a) it                      --> it    (no abbreviation)
//
//      1
// b) d|o|g                   --> d1g
//
//               1    1  1
//      1---5----0----5--8
// c) i|nternationalizatio|n  --> i18n
//
//               1
//      1---5----0
// d) l|ocalizatio|n          --> l10n
//
// Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
// A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
//
// Example:
//
// Given dictionary = [ "deer", "door", "cake", "card" ]
//
// isUnique("dear") -> false
// isUnique("cart") -> true
// isUnique("cane") -> false
// isUnique("make") -> true
public class ValidWordAbbr {
    Map<String, Set<String>> map;
    public ValidWordAbbr(String[] dictionary) {
      map = new HashMap<>();
      for (String s : dictionary){
        String abbr = getAbbr(s);
        if (map.get(abbr) == null) map.put(abbr, new HashSet<String>());
        map.get(abbr).add(s);
      }
    }

    private String getAbbr(String s){
      if (s.length() <= 2) return s;
      StringBuilder sb = new StringBuilder();
      sb.append(s.charAt(0)).append(s.length()-2).append(s.charAt(s.length()-1));
      return sb.toString();
    }

    public boolean isUnique(String word) {
      String abbr = getAbbr(word);
      if (map.get(abbr) == null) return true;
      else if (map.get(abbr).contains(word)) return map.get(abbr).size() <= 1;
      else return false;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
