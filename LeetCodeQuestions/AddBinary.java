public class AddBinary {
    // LeetCode Solution Method
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }

    // Main method to run and test in VS Code
    public static void main(String[] args) {
        // Test Case 1
        String a1 = "11", b1 = "1";
        System.out.println("Input: a = \"" + a1 + "\", b = \"" + b1 + "\"");
        System.out.println("Output: \"" + addBinary(a1, b1) + "\"\n"); // Expected: "100"

        // Test Case 2
        String a2 = "1010", b2 = "1011";
        System.out.println("Input: a = \"" + a2 + "\", b = \"" + b2 + "\"");
        System.out.println("Output: \"" + addBinary(a2, b2) + "\""); // Expected: "10101"
    }
}
