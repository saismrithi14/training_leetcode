public class ConnectedComponentsSortedArray {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp = new int[nums.length];
        boolean[] finalResult = new boolean[queries.length];
        int comNumber = 0;
        int i = 0;
        while(i+1 < nums.length)
        {
            if(Math.abs(nums[i] - nums[i+1]) <= maxDiff)
            {
                comp[i] = comNumber;
                comp[i+1] = comNumber;
                i++;
            }

            else
            {
                comp[i] = comNumber;
                comNumber++;
                comp[i+1] = comNumber;
                i++;
            }

        }

        for(int j = 0; j < queries.length; j++)
        {
            int left = queries[j][0];
            int right = queries[j][1];
            if(comp[left] == comp[right])
            {
                finalResult[j] = true;
            }
            else
            {
                finalResult[j] = false;
            }
        }
        return finalResult;

    }
}
