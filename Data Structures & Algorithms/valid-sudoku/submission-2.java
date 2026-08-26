class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // Check rows
        for (int i = 0; i < n; i++) {
            Set<Character> hs = new HashSet<>();

            for (int j = 0; j < m; j++) {
                if (board[i][j] == '.') continue;

                if (!hs.add(board[i][j])) {
                    return false;
                }
            }
        }

        // Check columns
        for (int i = 0; i < m; i++) {
            Set<Character> hs = new HashSet<>();

            for (int j = 0; j < n; j++) {
                if (board[j][i] == '.') continue;

                if (!hs.add(board[j][i])) {
                    return false;
                }
            }
        }

        // Check 3x3 boxes
        for (int i = 0; i < 9; i++) {
            Set<Character> hs = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                int row = (i / 3) * 3 + (j / 3);
                int col = (i % 3) * 3 + (j % 3);

                if (board[row][col] == '.') continue;

                if (!hs.add(board[row][col])) {
                    return false;
                }
            }
        }

        return true;
    }
}