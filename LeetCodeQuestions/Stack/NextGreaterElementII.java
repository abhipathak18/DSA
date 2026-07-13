import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }

            if (i < n) {
                if (stack.isEmpty()) {
                    nge[i] = -1;
                } else {
                    nge[i] = stack.peek();
                }
            }

            stack.push(nums[i % n]);
        }

        return nge;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};

        int[] ans = nextGreaterElements(nums);

        System.out.println(Arrays.toString(ans));
    }
}