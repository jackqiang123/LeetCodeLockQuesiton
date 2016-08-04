// Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//
// For example, Given s = “eceba”,
//
// T is "ece" which its length is 3.
public class Solution{
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int len = s.length();
		if (len <= 2) return len;
		int i = 0; int j = 0;
		int curBest = 2;
		Map<Character, Integer> map = new HashMap<>();
		while(j < len){
			char c = s.charAt(j);
			if (map.size() < 2 || map.containsKey(c)){
				map.put(c, map.get(c)==null?1:(map.get(c)+1));
				j++;
			}
			else {
				curBest = Math.max(curBest, j - i);
				char last = s.charAt(i++);
				map.put(last, map.get(last) - 1);
				if (map.get(last) == 0) {
					map.remove(last);
					continue;
				}
			}
		}
		return Math.max(curBest, j-i);
	}
}
