class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> LocMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (LocMap.containsKey(diff)) {
                return new int[] { LocMap.get(diff), i};
            }
            LocMap.put(nums[i], i);
        }

        return new int[] {};
    }
}
