public class MaximumSubstrings {
    public int maxDistinct(String s) {
        return s.chars().mapToObj(x->(char)x).distinct().toList().size ();

    }
}
