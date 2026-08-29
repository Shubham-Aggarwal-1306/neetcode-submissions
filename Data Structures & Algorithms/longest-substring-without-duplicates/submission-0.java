class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mpp = new HashMap<>();

        int left = 0;
        int right = 0;
        int high = 0;

        while (right < s.length()) {
            if (mpp.containsKey(s.charAt(right))) {
                left = Math.max(left, mpp.get(s.charAt(right)) + 1);
                
            }
            mpp.put(s.charAt(right), right);
            high = Math.max(high, right - left + 1);
            right++;
        }
        return high;
    }
}