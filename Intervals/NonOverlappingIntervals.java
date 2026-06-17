public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int totalIntervals = intervals.length;
        int nonOverlapping = 0;
        Arrays.sort(intervals, (a,b)->a[1] - b[1]);
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++)
        {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];

            if(curStart < prevEnd)
            {
                continue;
            }

            else
            {
                prevStart = curStart;
                prevEnd = curEnd;
                nonOverlapping++;
            }
        }
        nonOverlapping++;
        return totalIntervals - nonOverlapping;
    }
}