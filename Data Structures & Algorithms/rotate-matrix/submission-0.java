class Solution {
    private void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            arr[left] = arr[left] + arr[right];
            arr[right] = arr[left] - arr[right];
            arr[left] = arr[left] - arr[right];

            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {
       int n = matrix.length;

       for (int i = 0; i<n; i++) {
        for (int j = i+1; j<n; j++) {
            matrix[i][j] = matrix[i][j] + matrix[j][i];
            matrix[j][i] = matrix[i][j] - matrix[j][i];
            matrix[i][j] = matrix[i][j] - matrix[j][i];
        }
       }

       for (int i = 0; i<n; i++) {
        reverse(matrix[i]);
       }
    }
}
