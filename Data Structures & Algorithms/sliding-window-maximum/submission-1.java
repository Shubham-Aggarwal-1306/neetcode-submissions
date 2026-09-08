class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        while (l <= n - k) {
            maxHeap.offer(new int[]{nums[r], r});
            r++;

            while (( r - l + 1) > k) {
                int[] curr = maxHeap.peek();
                ans[l] = curr[0];

                if (curr[1] == l) {
                    while (!maxHeap.isEmpty() && maxHeap.peek()[1] <= l) {
                        maxHeap.poll();
                    }
                }
                l++;
            }
        }

        return ans;
    }
}
