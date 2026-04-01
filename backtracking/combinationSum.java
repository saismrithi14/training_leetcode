
import java.util.*;
public class combinationSum
{
    private void dfs(List<Integer> sub_list, List<List<Integer>> final_list, int[] candidates, int target,int i)
    {
        if(sub_list.stream().mapToInt(Integer::intValue).sum() == target)
        {
            List<Integer> copy_list = new ArrayList<>();
            for(int element: sub_list)
            {
                copy_list.add(element);
            }

            final_list.add(copy_list);
            return;
        }

        else if(sub_list.stream().mapToInt(Integer::intValue).sum() > target)
        {
            return;
        }
        else
        {

            for(int j = i; j < candidates.length; j++)
            {
                sub_list.add(candidates[j]);
                dfs(sub_list,final_list,candidates,target,j);
                sub_list.remove(sub_list.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> final_list = new ArrayList<>();
        List<Integer> sub_list = new ArrayList<>();
        dfs(sub_list,final_list,candidates,target,0);
        return final_list;

    }
}