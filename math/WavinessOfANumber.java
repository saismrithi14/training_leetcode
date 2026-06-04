public class WavinessOfANumber {
    private int waviness(int number)
    {
        if(number < 100) return 0;
        int waveCount = 0;
        String numberString = Integer.toString(number);
        int i = 1;
        while(i-1 >=0 && i+1 < numberString.length())
        {
            int prev = numberString.charAt(i-1) - '0';
            int current = numberString.charAt(i) - '0';
            int future = numberString.charAt(i+1) - '0';

            if(current > prev && current > future) waveCount ++;
            if(current < prev && current < future) waveCount++;
            i++;
        }

        return waveCount;
    }
    public int totalWaviness(int num1, int num2) {
        int totalSum = 0;
        for(int i = num1; i <= num2; i++)
        {
            totalSum += waviness(i);
        }

        return totalSum;
    }
}