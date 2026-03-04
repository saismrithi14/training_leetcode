public class single_number {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int element: nums)
        {
            xor = xor ^ element;
        }

        return xor;

    }
}
