class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];
        // Check rows
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                int val = board[i][j];
                if (val == '.') continue;

                if ((rows[i] & (1 << val)) > 0 || 
                    (cols[j] & (1 << val)) > 0 ||
                    (squares[(i/3)*3 + j/3] & (1 << val)) > 0)
                    return false;
                rows[i] |= 1 << val;
                cols[j] |= 1 << val;
                squares[(i/3)*3 + j/3] |= 1 << val;
            }
        }
        return true;
    }
}