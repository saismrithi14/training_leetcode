import java.util.*;

class SolutionNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(true)
        {
            int new_sum = sum_of_squares_of_digits(n);
            if(new_sum == 1)
            {
                return true;
            }

            else if(set.contains(new_sum))
            {
                break;
            }

            set.add(new_sum);
            n = new_sum;
        }

        return false;
    }

    private int sum_of_squares_of_digits(int n)
    {
        int total_sum = 0;
        while(n!=0)
        {
            int digit = n%10;
            total_sum += (digit * digit);
            n = n/10;
        }

        return total_sum;
    }
}

public class happyNumber {
        public static void main(String[] args) {
            SolutionNumber sol = new SolutionNumber();
            int n = 2;
            boolean result = sol.isHappy(n);

            System.out.println(n + " is happy? " + result);
        }
}
