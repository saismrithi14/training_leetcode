import java.util.Stack;

public class minstack {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    public minstack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(min_stack.isEmpty() || val <= min_stack.peek())
        {
            min_stack.push(val);
        }
    }

    public void pop()
    {
        if(!stack.isEmpty())
        {
            int val = stack.pop();
            if(!min_stack.isEmpty() && val == min_stack.peek())
            {
                min_stack.pop();
            }

        }

    }

    public int top() {
        if(!stack.isEmpty())
        {
            return stack.peek();
        }

        else
        {
            return -1;
        }

    }

    public int getMin() {
        if(!min_stack.isEmpty())
        {
            return min_stack.peek();
        }

        return -1;

    }
}
