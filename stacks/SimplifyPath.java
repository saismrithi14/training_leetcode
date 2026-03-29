import java.util.Stack;
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] filenames = path.split("/+");
        Stack<String> stack = new Stack<>();

        System.out.println();

        for(String s: filenames)
        {
            if(s.equals(".."))
            {
                if(stack.size()!=0)
                {
                    stack.pop();
                }
            }
            else if(!s.equals(".") && !s.equals(""))
            {
                stack.push(s);
            }

            else{}
        }
        if(stack.isEmpty()){return "/";}
        StringBuilder sb = new StringBuilder();
        for(String element: stack)
        {
            if(element.equals("")){continue;}
            sb.append("/").append(element);
        }

        return sb.toString();
    }
}
