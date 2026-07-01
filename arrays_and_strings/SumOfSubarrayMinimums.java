import java.util.*;
public class SumOfSubarrayMinimums {

    public static int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;

        int[] pse = new int[n];
        int[] nse = new int[n];
        Arrays.fill(pse, -1);
        Arrays.fill(nse, n);

        Stack<Integer> st = new Stack<>();

        // PSE (previous smaller)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // NSE (next smaller)
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            ans = (ans + (long) arr[i] * left * right) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        int[] array = {3,1,2,4};
        System.out.println(sumSubarrayMins(array));
    }

}
