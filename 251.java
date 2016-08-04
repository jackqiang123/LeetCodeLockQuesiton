// Implement an iterator to flatten a 2d vector.
//
// For example, Given 2d vector =
//
// [
//   [1,2],
//   [3],
//   [4,5,6]
// ]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
public class Vector2D implements Iterator<Integer> {
  int i = 0;
  int j = 0;
  List<List<Integer>> vec2d;
  public Vector2D(List<List<Integer>> vec2d) {
    this.vec2d = vec2d;
  }
    public Integer next(){
      return vec2d.get(i).get(j++);
    }
    public boolean hasNext(){
      while(i < vec2d.size() && j == vec2d.get(i).size()) {
        i++; j = 0;
      }
      return i < vec2d.size();
    }
}
