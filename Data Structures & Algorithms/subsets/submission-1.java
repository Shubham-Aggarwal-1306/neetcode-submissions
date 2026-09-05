class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList<>());

        for (int n: nums) {
            int size = ans.size();
            for (int i = 0; i<size; i++) {
                List<Integer> curr = new ArrayList<>(ans.get(i));
                curr.add(n);
                ans.add(curr);
            }
        }

        return ans;
    }
}
