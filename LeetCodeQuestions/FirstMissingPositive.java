import java.util.HashSet;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        int i = 1;

        while (true) {
            if (!set.contains(i)) {
                return i;
            }
            i++;
        }
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, -1, 1};

        int ans = firstMissingPositive(nums);

        System.out.println(ans);
    }
}