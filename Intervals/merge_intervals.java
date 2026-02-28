import java.util.*;

class merge_intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<List<Integer>> final_list = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++)
        {
            int current_start = intervals[i][0];
            int current_end = intervals[i][1];
            if(current_start <= end)
            {
                start = Math.min(current_start, start);
                end = Math.max(end, current_end);
            }

            else
            {
                ArrayList<Integer> a1 = new ArrayList<>();
                a1.add(start);
                a1.add(end);
                final_list.add(a1);
                start = current_start;
                end = current_end;
            }
        }

        final_list.add(List.of(start,end));
        int[][] arr = new int[final_list.size()][];
        for(int i = 0; i < final_list.size(); i++)
        {
            List<Integer> list = final_list.get(i);
            arr[i] = new int[list.size()];
            for(int j = 0; j < 2; j++)
            {
                arr[i][j] = list.get(j);
            }
        }

        return arr;

    }
}