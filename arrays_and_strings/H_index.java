import java.util.*;
public class H-index {
    int hIndex(int[] citations) {
        int h = 0;
        Arrays.sort(citations);
        int length = citations.length;
        for(int i = length - 1; i >= 0; i--)
        {
            if(citations[i] >= length-i)
            {
                h = length-i;
            }
        }

        return h;

    }
}