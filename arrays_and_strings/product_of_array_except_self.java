import java.util.*;
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix_product = new int[nums.length];
        int[] suffix_product = new int[nums.length];

        prefix_product[0] = 1;
        suffix_product[nums.length-1] = 1;
        for(int i = 1; i < nums.length; i++)
        {
            prefix_product[i] = prefix_product[i-1] * nums[i-1];
        }

        for(int j = nums.length - 2; j >= 0; j--)
        {
            suffix_product[j] = suffix_product[j+1] * nums[j+1];
        }

        int[] final_product = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            final_product[i] = suffix_product[i] * prefix_product[i];
        }

        return final_product;

    }
}

public class product_of_array_except_self
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++)
        {
            System.out.println("Enter element " + (i+1));
            int element = sc.nextInt();
            arr[i] = element;
        }

        Solution s = new Solution();
        System.out.println("The final array is as follows: ");
        int [] final_array = s.productExceptSelf(arr);
        for(int element: final_array)
        {
            System.out.println(element);
        }

    }

}