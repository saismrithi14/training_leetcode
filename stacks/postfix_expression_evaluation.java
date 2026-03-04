class postfix_expression_evaluation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length;i++)
        {
            try
            {
                int value = Integer.parseInt(tokens[i]);
                stack.push(value);
            }

            catch(NumberFormatException ne)
            {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(tokens[i].equals("+"))
                {
                    stack.push(num1 + num2);
                }

                else if(tokens[i].equals("-"))
                {
                    stack.push(num1 - num2);
                }

                else if(tokens[i].equals("*"))
                {
                    stack.push(num1 * num2);
                }

                else
                {
                    stack.push(num1/ num2);
                }
            }

            finally
            {
                continue;
            }
        }

        return stack.pop();
    }
}