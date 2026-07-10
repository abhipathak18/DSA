import java.util.Stack;

public class SingleElementInAnArray {
    public static int singleNonDuplicate(int[] nums) {
        Stack<Integer> st = new Stack<>();

        for (int num : nums) {
            if (!st.isEmpty() && st.peek() == num) {
                st.pop();
            } else {
                st.push(num);
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};

        int result = singleNonDuplicate(nums);
        System.out.println("Single non-duplicate element: " + result);
    }
}