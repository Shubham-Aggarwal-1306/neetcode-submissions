class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m*n - 1;

        while (l <= r) {
            int mid = ( r + l + 1 ) / 2;
            if (matrix[mid/n][mid%n] > target) {
                r = mid - 1;
            } else if (matrix[mid/n][mid%n] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
