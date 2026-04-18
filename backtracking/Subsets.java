import java.util.*;

public class Subsets {
    private List<List<Integer>> final_list = new ArrayList<>();
    private List<Integer> sub_list = new ArrayList<>();
    private void dfs(int i, int[] nums)
    {
        if(i==nums.length)
        {
            ArrayList<Integer> arr = new ArrayList<>();
            for(Integer num: sub_list)
            {
                arr.add(num);
            }
            final_list.add(arr);
            return;
        }
        else
        {
            sub_list.add(nums[i]);
            dfs(i+1,nums);
            sub_list.remove(sub_list.size()-1);
            dfs(i+1,nums);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return final_list;

    }
}
