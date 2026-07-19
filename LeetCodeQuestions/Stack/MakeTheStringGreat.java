public class MakeTheStringGreat {

    public static String makeGood(String s) {

        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (stack.length() > 0 &&
                Math.abs(stack.charAt(stack.length() - 1) - c) == 32) {

                // Pop
                stack.deleteCharAt(stack.length() - 1);

            } else {

                // Push
                stack.append(c);
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {

        String s = "leEeetcode";

        System.out.println(makeGood(s));
    }
}