package strings;
import java.util.*;
public class DecodingString {

    public static String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int number = 0;
        for(int i = 0; i < s.length(); i++)
        {
            //System.out.println("Character is: " + s.charAt(i));
            if(Character.isDigit(s.charAt(i)))
            {
                //System.out.println("Character is a number");
                number = number * 10 + (s.charAt(i) - '0');
            }

            else if(s.charAt(i) == '[')
            {
                //System.out.println("Character is an open bracket");
                numberStack.push(number);
                stringStack.push(currentString.toString());
                currentString.setLength(0);
                number = 0;
            }

            else if(s.charAt(i) == ']')
            {
                //System.out.println("Character is a closed bracket");
                int poppedNumber = numberStack.pop();
                String repeatingString = currentString.toString();
                for(int j = 0; j < poppedNumber - 1; j++)
                {
                    currentString.append(repeatingString);
                }
                String previousString = stringStack.pop();
                currentString.insert(0,previousString);
            }

            else
            {
                //System.out.println("Character is a letter");
                currentString.append(Character.toString(s.charAt(i)));
            }
        }

        return currentString.toString();

    }
    public static void main(String[] args) {

        System.out.println(DecodingString.decodeString("3[ab]"));

    }
}
