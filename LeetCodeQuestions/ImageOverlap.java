import java.util.*;

public class ImageOverlap {

    public static int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;

        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (img1[i][j] == 1) {
                    ones1.add(new int[]{i, j});
                }

                if (img2[i][j] == 1) {
                    ones2.add(new int[]{i, j});
                }
            }
        }

        // Map to count how many times each translation occurs
        Map<String, Integer> map = new HashMap<>();

        int ans = 0;

        // Compare every 1 in img1 with every 1 in img2
        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {

                int dx = p2[0] - p1[0];
                int dy = p2[1] - p1[1];

                String key = dx + "," + dy;

                int count = map.getOrDefault(key, 0) + 1;

                map.put(key, count);

                ans = Math.max(ans, count);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] img1 = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 1, 0}
        };

        int[][] img2 = {
            {0, 0, 0},
            {0, 1, 1},
            {0, 0, 1}
        };

        int result = largestOverlap(img1, img2);

        System.out.println("Maximum Overlap = " + result);
    }
}