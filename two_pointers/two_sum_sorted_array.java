class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int [] final_result = new int[2];
        while(left < right)
        {
            if(numbers[left] + numbers[right] == target)
            {
                final_result[0] = left + 1;
                final_result[1] = right + 1;
                return final_result;
            }

            else if(numbers[left] + numbers[right] > target)
            {
                right --;
            }

            else
            {
                left ++;
            }
        }

        return final_result;
        
    }
}