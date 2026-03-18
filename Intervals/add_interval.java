import java.util.*;
class SolutionInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int flag = 0;
        for(int i = 0; i < intervals.length; i++)
        {
            //check if the new interval comes after an interval
            if(intervals[i][1] < newInterval[0])
            {
                list.add(intervals[i]);
            }

            else if(newInterval[1] < intervals[i][0])
            {
                list.add(newInterval);
                for(int j = i; j < intervals.length; j++)
                {

                    list.add(intervals[j]);
                }

                flag = 1;
                break;
            }
            else
            {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }

        if(flag == 0)
        {
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][]);
    }
}

public class add_interval {
    public static void main(String[] args) {
        SolutionInterval solution = new SolutionInterval();

        // Test input
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        // Call insert method
        int[][] result = solution.insert(intervals, newInterval);

        // Print result
        System.out.println("Merged intervals:");
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}