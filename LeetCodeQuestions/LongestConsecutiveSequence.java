import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Add all elements to HashSet (removes duplicates)
        for (int num : nums) {
            set.add(num);
        }

        // Convert HashSet to Array
        Integer[] arr = set.toArray(new Integer[0]);

        // If array is empty
        if (arr.length == 0) {
            return 0;
        }

        // Sort the array
        Arrays.sort(arr);

        int longest = 1;
        int count = 1;

        // Find longest consecutive sequence
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1] + 1) {
                count++;
            } else {
                longest = Math.max(longest, count);
                count = 1;
            }
        }

        longest = Math.max(longest, count);

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}