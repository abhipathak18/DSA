
public class RemoveDuplicatesII {

    public static int removeDuplicates(int[] nums) {

        int k = 0; // Position where next valid element will be placed

        for (int num : nums) {

            // Allow first two occurrences of every number.
            // If k >= 2, check whether current number is different
            // from the number two positions before.
            if (k < 2 || num != nums[k - 2]) {

                // Place valid number at index k
                nums[k] = num;

                // Move pointer forward
                k++;
            }
        }

        // k represents the length of the modified array
        return k;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};

        int k = removeDuplicates(nums);

        System.out.println("Length: " + k);

        System.out.print("Array: ");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}