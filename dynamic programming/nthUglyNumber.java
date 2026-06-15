public class nthUglyNumber
{
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0, i3=0,i5=0;
        for(int i = 1; i < n; i++)
        {
            int next_num = Math.min(list.get(i2) * 2, Math.min(list.get(i3) * 3, list.get(i5) * 5));
            list.add(next_num);
            if(next_num == list.get(i2) * 2) i2++;
            if(next_num == list.get(i3) * 3) i3++;
            if(next_num == list.get(i5) * 5) i5++;
        }

        return list.get(n-1);

    }
}