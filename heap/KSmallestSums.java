static class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    List<List<Integer>> result = new ArrayList<>();

    if (nums1.length == 0 || nums2.length == 0 || k == 0) {
        return result;
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) ->
                    (nums1[a.i] + nums2[a.j]) -
                            (nums1[b.i] + nums2[b.j])
    );

    Set<String> visited = new HashSet<>();

    pq.offer(new Pair(0, 0));
    visited.add("0,0");

    while (!pq.isEmpty() && result.size() < k) {

        Pair current = pq.poll();

        int i = current.i;
        int j = current.j;

        result.add(Arrays.asList(nums1[i], nums2[j]));

        // Move down
        if (i + 1 < nums1.length) {

            String key = (i + 1) + "," + j;

            if (!visited.contains(key)) {
                pq.offer(new Pair(i + 1, j));
                visited.add(key);
            }
        }

        // Move right
        if (j + 1 < nums2.length) {

            String key = i + "," + (j + 1);

            if (!visited.contains(key)) {
                pq.offer(new Pair(i, j + 1));
                visited.add(key);
            }
        }
    }

    return result;
}