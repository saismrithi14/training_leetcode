import java.util.ArrayList;
import java.util.List;
public class Combinations {
    private void traversal(int n, int k, List<List<Integer>>list, List<Integer> sub_list,int i)
    {
        if(sub_list.size() == k)
        {
            List<Integer> new_list = new ArrayList<>();
            for(Integer x : sub_list)
            {
                new_list.add(x);
            }

            list.add(new_list);
            return;
        }

        for(int j = i+1; j <= n; j++)
        {
            sub_list.add(j);
            traversal(n,k,list,sub_list,j);
            sub_list.remove(sub_list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> sub_list = new ArrayList<>();
        List<List<Integer>> final_list = new ArrayList<>();
        traversal(n,k,final_list,sub_list,0);
        return final_list;

    }
}
