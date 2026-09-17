class Solution {
public int dfs(int i, int j, int m , int n, int[][] grid, int[][] visited) {
        if (i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0 || visited[i][j] == 1) {
            return 0;
        }

        visited[i][j] = 1;
        int size = 1;
        size += dfs(i, j+1,m , n,grid,visited);
        size += dfs(i+1, j,m , n,grid,visited);
        size += dfs(i,j-1,m , n,grid,visited);
        size += dfs(i-1,j,m , n,grid,visited);

        return size;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int maxSize = 0;
        int islands = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1 && visited[i][j] != 1) {
                    islands++;
                    int size = dfs(i, j,m , n, grid, visited);
                    maxSize = Math.max(size, maxSize);
                }
            }
        }
        return maxSize;
    }
}
