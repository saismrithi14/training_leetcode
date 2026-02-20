import java.util.*;
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for(int i = nums.length - 1; i >=0; i--)
        {
            if(i + nums[i] >= goal)
            {
                goal = i;
            }
        }

        return goal == 0;

    }
}

public class jump_game_1
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int length = sc.nextInt();
        int[] hops = new int[length];
        int count = 0;
        while(count < length) {
            System.out.println("Enter element " + Integer.toString(count + 1));
            int element = sc.nextInt();
            hops[count] = element;
            count++;
        }
        System.out.println("Can the end of the array be reached?: " + s.canJump(hops));


    }
}
