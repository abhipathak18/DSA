public class MinimumDeletions {

    public static int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        // Find indices of minimum and maximum
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int left = Math.max(minIndex, maxIndex) + 1;
        int right = n - Math.min(minIndex, maxIndex);

        int bothSides =
                Math.min(minIndex, maxIndex) + 1
                + n - Math.max(minIndex, maxIndex);

        return Math.min(left, Math.min(right, bothSides));
    }

    public static void main(String[] args) {
        int[] nums = {2, 10, 7, 5, 4, 1, 8, 6};

        System.out.println(minimumDeletions(nums));
    }
}