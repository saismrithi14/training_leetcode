public class RemoveCoveredIntervals
{
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,
                Comparator.comparing((int[]a) ->a[0])
                        .thenComparing((a,b)->Integer.compare(b[1],a[1]))
        );
        int length = intervals.length;
        int count = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < length; i++)
        {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if(curStart >= start && curEnd <= end)
            {
                count++;
            }
            else
            {
                start = curStart;
                end = curEnd;
            }
        }

        return length - count;
    }
}