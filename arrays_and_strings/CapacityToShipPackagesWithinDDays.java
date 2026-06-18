public class CapacityToShipPackagesWithinDDays {
    private int numberOfDays(int[] weights, int capacity)
    {
        int count = 0, right = 0, totalSum = 0;
        while(right < weights.length)
        {
            while(right < weights.length && totalSum <= capacity)
            {
                totalSum += weights[right];
                if(totalSum > capacity) break;
                right++;
            }

            totalSum = 0;
            count++;

        }

        return count;
    }
    public int shipWithinDays(int[] weights, int days) {
        int lowerBound = Arrays.stream(weights).max().getAsInt();
        int upperBound = Arrays.stream(weights).sum();
        int minimumCapacity = Integer.MAX_VALUE;
        while(lowerBound <= upperBound)
        {
            int middle = (lowerBound + upperBound) / 2;
            int result = numberOfDays(weights, middle);
            if(result <= days){
                minimumCapacity = Math.min(middle, minimumCapacity);
                upperBound = middle - 1;
            }
            else
            {
                lowerBound = middle + 1;
            }
        }
        return minimumCapacity;
    }
}
