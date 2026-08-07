import java.util.*;

public class FindMissingElements {

    // Returns all missing integers between the minimum and maximum values
    // present in the given array.
    public static List<Integer> findMissingElements(int[] nums) {

        // Store the smallest and largest values in the array.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // HashSet for O(1) lookup of existing elements.
        HashSet<Integer> set = new HashSet<>();

        // Find the minimum, maximum, and store all elements in the HashSet.
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        // List to store the missing elements.
        List<Integer> ans = new ArrayList<>();

        // Check every number between min and max.
        for (int i = min + 1; i < max; i++) {

            // If the number is not present in the HashSet,
            // then it is a missing element.
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        // Return the list of missing elements.
        return ans;
    }

    public static void main(String[] args) {

        // Sample input.
        int[] nums = {1, 4, 2, 5};

        // Find the missing elements.
        List<Integer> result = findMissingElements(nums);

        // Print the result.
        System.out.println(result);
    }
}