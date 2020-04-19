class Solution {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new LinkedList<>(), res, n);
        return res;
    }

    private void backtrack(LinkedList<Integer> collection, List<List<Integer>> res, int n) {
        if (n == 1) return;
        if (collection.size() > 0) {
            ArrayList<Integer> t = new ArrayList<>(collection);
            t.add(n);
            res.add(t);
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i != 0) continue;
            if (collection.isEmpty() || collection.getLast() <= i) {
                collection.add(i);
                backtrack(collection, res, n / i);
                collection.remove(collection.size() - 1);
            }
        }
    }
}
