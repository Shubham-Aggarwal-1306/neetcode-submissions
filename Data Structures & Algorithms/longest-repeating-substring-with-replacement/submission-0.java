class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int l = 0;
        int maxf = 0;
        int maxWindow = 0;

        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A'] += 1;
            maxf = Math.max(maxf, freq[s.charAt(r) - 'A']);

            while ((r - l + 1) - maxf > k) {
                freq[s.charAt(l) - 'A'] -= 1;
                l++;
            }

            maxWindow = Math.max(maxWindow, (r - l + 1));

        }

        return maxWindow;
    }
}
