import java.util.*;
public class GenerateParentheses {
    private StringBuilder sb = new StringBuilder();
    private void traversal(int openCount, int closedCount, int n, List<String> final_list)
    {
        if(openCount == n && closedCount == n)
        {
            final_list.add(sb.toString());
            return;
        }

        if(openCount < n)
        {
            sb.append("(");
            traversal(openCount + 1, closedCount, n,final_list);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(closedCount < openCount)
        {
            sb.append(")");
            traversal(openCount, closedCount + 1, n, final_list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> validParentheses = new ArrayList<>();
        traversal(0,0,n,validParentheses);
        return validParentheses;
    }
}
