class Solution {
    private int maxOfArray(int[] array) {
        int ans = array[0];
        for (int i=0; i<array.length; i++) {
            ans=Math.max(ans, array[i]);
        }
        return ans;
    }

    private boolean canEat(int[] piles, int k, int h) {
        int ans = 0;
        for (int i=0; i<piles.length; i++) {
            ans+=(piles[i]/k) + ((piles[i]%k) > 0 ? 1 : 0);
            if (ans > h) {
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = maxOfArray(piles);
        int l = 1;
        int r = max;

        while (l<=r) {
            int mid = (r + l) / 2;
            if (canEat(piles, mid, h)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
        
    }
}
