// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//
// For example,
// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1
// m.next(10) = (1 + 10) / 2
// m.next(3) = (1 + 10 + 3) / 3
// m.next(5) = (10 + 3 + 5) / 3
public class MovingAverage {

    /** Initialize your data structure here. */
    double ave = 0;
    int size = 0;
    Queue<Integer> queue;
    public MovingAverage(int size) {
      this.queue = new LinkedList<>();
      this.ave = 0; this.size = size;
    }

    public double next(int val) {
      queue.add(val);
      if (queue.size() <= size){
        ave = (ave*(queue.size()-1) + val)*1.0/queue.size();
        return ave;
      }
      else {
        ave = (ave*(queue.size()-1) + val - queue.remove())*1.0/queue.size();
        return ave;
      }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
