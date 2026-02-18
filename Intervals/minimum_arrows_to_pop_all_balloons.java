class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b) -> Integer.compare(a[0],b[0]));
        int intersection_start = points[0][0];
        int intersection_end = points[0][1];
        int arrows = 1;
        for(int i = 1; i < points.length; i++)
        {
            int start = points[i][0];
            int end = points[i][1];

            if(intersection_end < start)
            {
                arrows += 1;
                intersection_start = start;
                intersection_end = end;
            }

            else
            {
                intersection_start = Math.max(intersection_start, start);
                intersection_end = Math.min(intersection_end, end);
            }
        }

        return arrows;
    }
}