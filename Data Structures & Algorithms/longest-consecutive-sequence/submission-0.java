class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        for (int num: nums) {
            if (!mp.containsKey(num)) {
                int length = mp.getOrDefault(num - 1, 0) + mp.getOrDefault(num + 1, 0) + 1;
                mp.put(num, length);
                
                mp.put(num - mp.getOrDefault(num - 1, 0), length);
                mp.put(num + mp.getOrDefault(num + 1, 0), length);

                res = Math.max(res, length);
            }
        }
        return res;
    }
}
