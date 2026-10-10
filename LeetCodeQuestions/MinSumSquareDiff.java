import java.util.Arrays;

public class MinSumSquareDiff {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        // Find the maximum difference to size our frequency array
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums1[i] - nums2[i]));
        }

        // Count frequencies of each absolute difference
        int[] counts = new int[maxDiff + 1];
        for (int i = 0; i < n; i++) {
            counts[Math.abs(nums1[i] - nums2[i])]++;
        }

        // Process differences from largest to smallest
        for (int d = maxDiff; d > 0; d--) {
            if (counts[d] == 0) continue;

            // Determine how many elements we can reduce from difference `d` to `d - 1`
            long take = Math.min(k, (long) counts[d]);
            counts[d] -= take;
            counts[d - 1] += take;
            k -= take;

            // If all operations are used up, stop early
            if (k == 0) break;
        }

        // Calculate the final minimum sum of squared differences
        long minSquaredSum = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (counts[d] > 0) {
                minSquaredSum += (long) counts[d] * (long) d * d;
            }
        }

        return minSquaredSum;
    }

    // Main method to run and verify test cases within VS Code
    public static void main(String[] args) {
        MinSumSquareDiff solver = new MinSumSquareDiff();

        // Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {2, 10, 20, 19};
        int k1 = 0;
        int k2 = 0;
        System.out.println("Test Case 1 Output: " + solver.minSumSquareDiff(nums1, nums2, k1, k2)); 
        // Expected: 579

        // Test Case 2
        int[] nums1_2 = {1, 4, 10, 12};
        int[] nums2_2 = {5, 8, 6, 9};
        int k1_2 = 1;
        int k2_2 = 1;
        System.out.println("Test Case 2 Output: " + solver.minSumSquareDiff(nums1_2, nums2_2, k1_2, k2_2)); 
        // Expected: 43
    }
}
