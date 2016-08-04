// Design and implement a TwoSum class. It should support the following operations: add and find.
//
// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.
//
// For example,
//
// add(1);
// add(3);
// add(5);
// find(4) -> true
// find(7) -> false
public class TwoSum {

    // Add the number to an internal data structure.
    Map<Integer, Integer> map = new HashMap<>();
	public void add(int number) {
    if (map.get(number) == null) map.put(number, 1);
    else map.put(number, map.get(number)+1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
    for (int i : map.keySet()){
      int other = value - i;
      if (other == i && map.get(other) >= 2) return true;
      else if (other != i && map.get(other)!=null) return true;
    }
    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
