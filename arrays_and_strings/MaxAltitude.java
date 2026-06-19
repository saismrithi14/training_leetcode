public class MaxAltitude {
    public int largestAltitude(int[] gain) {
        int total_sum = 0;
        int max_altitude = 0;
        for(int i = 0; i < gain.length; i++)
        {
            total_sum += gain[i];
            max_altitude = Math.max(max_altitude, total_sum);
        }

        return max_altitude;

    }
}
