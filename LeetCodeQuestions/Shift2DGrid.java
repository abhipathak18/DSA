import java.util.*;

public class Shift2DGrid {

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k %= total;
        int[][] shifted = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newIndex = (i * n + j + k) % total;
                shifted[newIndex / n][newIndex % n] = grid[i][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(shifted[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int k = 1;

        System.out.println(shiftGrid(grid, k));
    }
}