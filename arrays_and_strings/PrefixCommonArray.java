import java.util.*;
public class PrefixCommonArray {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] final_result = new int[A.length];
        Set<Integer> seenA = new HashSet<>();
        Set<Integer> seenB = new HashSet<>();

        int count = 0;

        for(int i = 0; i < A.length;i++)
        {
            if(A[i] == B[i])
            {
                seenA.add(A[i]);
                count += 1;
                final_result[i] = count;
            }

            else
            {
                seenA.add(A[i]);
                seenB.add(B[i]);
                if(seenB.contains(A[i])) count++;
                if(seenA.contains(B[i])) count++;

                final_result[i] = count;
            }
        }

        return final_result;

    }
}
