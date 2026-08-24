public class MaximumValueOfAString {

    public static int maximumValue(String[] strs) {
        int max = 0;

        for (String s : strs) {
            int value = 0;
            boolean isDigit = true;

            for (char ch : s.toCharArray()) {
                if (ch < '0' || ch > '9') {
                    isDigit = false;
                }
            }

            if (isDigit) {
                value = Integer.parseInt(s);
            } else {
                value = s.length();
            }

            max = Math.max(max, value);
        }

        return max;
    }

    public static void main(String[] args) {
        String[] strs = {"alic3", "bob", "3", "4", "00000"};

        System.out.println(maximumValue(strs));
    }
}