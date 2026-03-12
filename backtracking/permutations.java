import java.util.*;
class Permutations {
    private void traversal(List<List<Integer>> final_list, List<Integer> sub_list, int[] nums)
    {
        if(sub_list.size() == nums.length)
        {
            List<Integer> new_list = new ArrayList<>(sub_list);
            final_list.add(new_list);
            return;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(!sub_list.contains(nums[i]))
            {
                sub_list.add(nums[i]);
                traversal(final_list, sub_list, nums);
                sub_list.remove(sub_list.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> final_list = new ArrayList<>();
        List<Integer> sub_list = new ArrayList<>();
        traversal(final_list, sub_list, nums);
        return final_list;
    }
}