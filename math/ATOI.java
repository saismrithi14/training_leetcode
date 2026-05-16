public class ATOI
{
    public int myAtoi(String s) {
        long final_result = 0;
        boolean foundSign = false;
        boolean isNegative = false;
        boolean foundDigit = false;
        int i = 0;

        //this is for ignoring the leading white spaces
        while(i < s.length() && s.charAt(i) == ' ')
        {
            i++;
        }

        while(i < s.length())
        {
            if(s.charAt(i) == '+' || s.charAt(i) == '-')
            {
                if(foundDigit)
                {
                    return isNegative ?(int) -final_result : (int)final_result;
                }
                if(foundSign)
                {
                    return isNegative ?(int) -final_result :(int) final_result;
                }

                foundSign = true;
                if(s.charAt(i) == '-')
                {
                    isNegative = true;
                }

            }

            else if(Character.isDigit(s.charAt(i)))
            {
                foundDigit = true;
                int digit = s.charAt(i) - '0';
                if(final_result > Integer.MAX_VALUE / 10 ||
                        (final_result == Integer.MAX_VALUE / 10 &&
                                digit > (isNegative ? 8 : 7)))
                {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                else
                {
                    final_result = final_result * 10 + (s.charAt(i) - '0');
                }
            }


            else
            {
                return isNegative ? (int)-final_result :(int) final_result;
            }

            i++;
        }

        return isNegative ?(int) -final_result :(int) final_result;

    }
}