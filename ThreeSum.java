public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalList = new ArrayList<>();
        for(int i = 0; i < nums.length;i++)
        {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            else
            {
                int left = i+1;
                int right = nums.length - 1;
                while(left < right)
                {
                    int sum = nums[left] + nums[right] + nums[i];
                    if(sum == 0)
                    {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[left]);
                        subList.add(nums[right]);
                        finalList.add(subList);
                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left-1]) left++;
                        while(left < right && right+1 < nums.length && nums[right] == nums[right+1] ) right--;
                    }

                    else if(sum < 0)
                    {
                        left++;
                    }

                    else
                    {
                        right --;
                    }
                }
            }
        }
        return finalList;
    }
}