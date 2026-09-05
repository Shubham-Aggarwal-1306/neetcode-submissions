class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];

        for (int i = 0; i<temperatures.length; i++) {
            int ind = 0;
            for (int j = i + 1; j<temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    ind = j;
                    break;
                }
            }
            if (ind > 0) {
                results[i] = ind - i;
            } else {
                results[i] = 0;
            }
        }

        return results;
    }
}
