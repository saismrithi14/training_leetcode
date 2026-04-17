public class CountDigitAppearances
{
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for(Integer num: nums)
        {
            while(num!= 0)
            {
                int last_digit = num%10;
                if(last_digit == digit) count++;
                num = num / 10;
            }
        }

        return count;

    }
}
