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
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        List<Integer> startList = new ArrayList<>();
        List<Integer> endList = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            startList.add(intervals.get(i).start);
            endList.add(intervals.get(i).end);
        }

        Collections.sort(startList);
        Collections.sort(endList);

        int res = 0;
        int count = 0;

        int i=0, j=0;

        while(i<startList.size() && j<endList.size())
        {
            if(startList.get(i)<endList.get(j))
            {
                count++;
                res = Math.max(res, count);
                i++;
            }
            else if(startList.get(i)>endList.get(j))
            {
                count--;
                j++;
            }
            else
            {
                count--;
                j++;
            }
        }
        
        return res;
    }
}
