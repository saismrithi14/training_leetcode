class Solution {
    public void rotate(int[] nums, int k) {
        //first rotate the last k elements
        k = k % nums.length;
        if(nums.length != 1){
        int last_index = nums.length - 1;
        int right = last_index;
        int left = last_index - k + 1;
        System.out.println("Left's index is: " + left);
        System.out.println("Right index is: " + right);
        while(left <= right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left ++;
            right --;
        }

    
        // next for the first n-k elements that we ignored
        right = last_index - k;
        left = 0;
        
        while(left <= right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }

        left = 0;
        right = last_index;
        while(left <= right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }

        }
    }
}