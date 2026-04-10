import java.util.*;
public class greyCode {
    public List<Integer> grayCode(int n) {
        List<Integer> final_list = new ArrayList<>();
        for(int i = 0; i < Math.pow(2,n); i++)
        {
            final_list.add(i^(i>>1));
        }

        return final_list;

    }
}
