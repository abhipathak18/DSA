import java.util.HashSet;

public class MissingInteger {

    public static int missingInteger(int[] nums) {

        // Step 1: Start sum with first element
        int sum = nums[0];

        // Step 2: Find sequential prefix
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Step 3: Put all numbers into HashSet
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Step 4: Find smallest missing number
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 1, 12, 14, 13};

        int answer = missingInteger(nums);

        System.out.println(answer);
    }
}