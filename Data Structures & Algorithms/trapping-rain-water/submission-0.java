class Solution {
    public int trap(int[] heights) {
        int prefixMax = 0;
        int suffixMax = 0;
        int n = heights.length;
        int[] prefixMaxes = new int[n];
        int[] suffixMaxes = new int[n];
        for (int i = 0; i<n; i++) {
            prefixMaxes[i] = prefixMax;
            prefixMax = Math.max(prefixMax, heights[i]);
        }
        for (int i = n - 1; i>-1; i--) {
            suffixMaxes[i] = suffixMax;
            suffixMax = Math.max(suffixMax, heights[i]);
        }

        int filled = 0;

        for (int i=0; i<n; i++) {
            filled = filled +  Math.max(Math.min(prefixMaxes[i], suffixMaxes[i]) - heights[i], 0);

        }

        return filled;
    }
}
