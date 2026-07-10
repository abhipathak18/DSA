import java.util.Stack;

public class BackspaceCompare {

    public static boolean backspaceCompare(String s, String t) {

        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != '#') {
                st1.push(c);
            } else if (!st1.isEmpty()) {
                st1.pop();
            }
        }

        for (char c : t.toCharArray()) {
            if (c != '#') {
                st2.push(c);
            } else if (!st2.isEmpty()) {
                st2.pop();
            }
        }

        return st1.equals(st2);
    }

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";

        boolean result = backspaceCompare(s, t);
        System.out.println(result);
    }
}