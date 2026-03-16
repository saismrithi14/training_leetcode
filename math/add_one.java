public class add_one
{
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int original_length = digits.length;
        int ptr = original_length - 1;
        int digit = digits[original_length - 1];
        int sum = digit + 1 + carry;
        digits[ptr] = sum % 10;
        carry = sum / 10;

        ptr --;
        while(ptr >=0)
        {
            sum = digits[ptr] + carry;
            digits[ptr] = sum % 10;
            carry = sum / 10;
            ptr --;
        }

        if(carry == 0)
        {
            return digits;
        }

        else
        {
            int[] newArray = new int[original_length + 1];
            for(int i = original_length - 1; i >= 0; i--)
            {
                newArray[i+1] = digits[i];
            }

            newArray[0] = carry;
            return newArray;
        }


    }
}