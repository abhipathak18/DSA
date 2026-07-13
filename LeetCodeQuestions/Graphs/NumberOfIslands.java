public class NumberOfIslands {

    public static void dfs(int i, int j, char[][] grid, boolean[][] vis, int m, int n) {

        if (i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == '0') {
            return;
        }

        vis[i][j] = true;

        dfs(i + 1, j, grid, vis, m, n); // Down
        dfs(i - 1, j, grid, vis, m, n); // Up
        dfs(i, j + 1, grid, vis, m, n); // Right
        dfs(i, j - 1, grid, vis, m, n); // Left
    }

    public static int numIslands(char[][] grid) {

        int island = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i, j, grid, vis, m, n);
                    island++;
                }
            }
        }

        return island;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of Islands: " + numIslands(grid));
    }
}