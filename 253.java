// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find
// the minimum number of conference rooms required.
//
// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return 2.
public class Solution {
public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
                        public int compare(Interval i1, Interval i2){
                                return i1.start - i2.start;
                        }
                });
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(1, new Comparator<Interval>(){
                        public int compare(Interval i1, Interval i2){
                                return i1.end - i2.end;
                        }
                });
        for (Interval i : intervals) {
                if (pq.isEmpty()) pq.add(i);
                else {
                        Interval top = pq.peek();
                        if (top.end > i.start) pq.add(i);
                        else {
                                pq.remove(); top.end = i.end; pq.add(top);
                        }
                }
        }
        return pq.size();
}
}
