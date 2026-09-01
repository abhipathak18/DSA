import java.util.Arrays;

public class FindColumnWidth {
    
    // LeetCode solution method
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length; // Fixed: safely gets the number of columns
        int[] ans = new int[n];
        
        for (int j = 0; j < n; j++) {
            int maxWidth = 0;
            for (int i = 0; i < m; i++) {
                int length = String.valueOf(grid[i][j]).length();
                maxWidth = Math.max(maxWidth, length);
            }
            ans[j] = maxWidth;
        }
        
        return ans;
    }

    // Main method to test your solution locally in VS Code
    public static void main(String[] args) {
        FindColumnWidth program = new FindColumnWidth();

        // Test Case: [[-15, 1, 3], [15, 7, 12], [5, 6, -2]]
        int[][] testGrid = {
            {-15, 1, 3},
            {15, 7, 12},
            {5, 6, -2}
        };

        int[] result = program.findColumnWidth(testGrid);
        
        // Prints: [3, 1, 2]
        System.out.println(Arrays.toString(result)); 
    }
}
