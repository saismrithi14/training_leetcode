class power {
    private double power(double x, int n)
    {
        if(n == 0)
        {
            return 1;
        }

        else if(n%2 != 0)
        {
            double half = power(x,n/2);
            return x * half * half;
        }

        else
        {
            double half = power(x,n/2);
            return half * half;
        }
    }

    public double myPow(double x, int n) {
        double result = power(x, Math.abs(n));
        if(n < 0)
        {
            return 1/result;
        }

        return result;

    }
}