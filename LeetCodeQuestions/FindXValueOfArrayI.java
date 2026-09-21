import java.util.Arrays;

public class FindXValueOfArrayI {

    public static long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at the
        // current position whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {
            int rem = num % k;

            long[] next = new long[k];

            // Subarray containing only the current element
            next[rem] = 1;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                int newRem = (int) ((long) r * rem % k);
                next[newRem] += dp[r];
            }

            // Add current subarrays to answer
            for (int r = 0; r < k; r++) {
                ans[r] += next[r];
            }

            dp = next;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int k = 3;

        long[] result = resultArray(nums, k);

        System.out.println(Arrays.toString(result));
    }
}