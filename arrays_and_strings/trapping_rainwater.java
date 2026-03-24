public class trapping_rainwater {
    public int trap(int[] height) {
        int size = height.length;
        int[] max_left = new int[size];
        int[] max_right = new int[size];

        int capacity = 0;
        int maximum_left = height[0];
        max_left[0] = maximum_left;
        for(int i = 1; i < size; i++)
        {
            if(height[i] > maximum_left)
            {
                maximum_left = height[i];
            }

            max_left[i] = maximum_left;
        }

        int maximum_right = height[size - 1];
        max_right[size-1] = maximum_right;
        for(int i = size - 2; i>=0; i--)
        {
            if(height[i] > maximum_right)
            {
                maximum_right = height[i];
            }

            max_right[i] = maximum_right;
        }

        for(int i = 0; i < size; i++)
        {
            int water = Math.min(max_left[i], max_right[i]) - height[i];
            if(water <= 0) water = 0;
            capacity += water;
        }
        return capacity;
    }
}