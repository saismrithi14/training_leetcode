public class SumAndConcat {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int[] final_result = new int[queries.length];
        int[] prefix_sum = new int[s.length() + 1];
        long[] x_build = new long[s.length() + 1];
        int[] cnt = new int[s.length() + 1];
        int nonZeroCount = 0;
        int mod = 1000000007;
        long[] pow10 = new long[s.length() + 1];
        pow10[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            pow10[i] = (pow10[i-1] * 10) % mod;
        }


        long number = 0;
        int prefix = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(Character.getNumericValue(s.charAt(i)) != 0)
            {
                prefix = prefix + Character.getNumericValue(s.charAt(i));
                prefix_sum[i+1] = prefix;
                number = (number * 10 + Character.getNumericValue(s.charAt(i)))%mod;
                x_build[i+1] = number;
                nonZeroCount++;
                cnt[i+1] = nonZeroCount;
            }
            else
            {
                prefix_sum[i+1] = prefix_sum[i];
                x_build[i+1] = x_build[i];
                cnt[i+1] = cnt[i];
            }
        }

        for(int i = 0; i < queries.length; i++)
        {
            int left = queries[i][0];
            int right = queries[i][1];
            int sum = prefix_sum[right+1] - prefix_sum[left];
            int count = cnt[right+1] - cnt[left];
            long x_value = ((x_build[right+1] - (x_build[left] * pow10[count]) % mod) % mod + mod) % mod;
            long result = x_value * sum;
            final_result[i] = (int) (result % mod);
        }

        return final_result;
    }
}