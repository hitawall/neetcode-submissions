/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        Collections.sort(intervals, new intervalComparator());

        for(int i=0; i<intervals.size()-1; i++)
        {
            Interval cur = intervals.get(i);
            Interval next = intervals.get(i+1);

            if(cur.end>next.start)
                return false; 
        }

        return true;

    }

    public class intervalComparator implements Comparator<Interval> {

        public int compare(Interval i1, Interval i2)
        {
            if(i1.start!=i2.start)
                return i1.start-i2.start;
            else
                return i1.end-i2.end;
        }
    }
}
