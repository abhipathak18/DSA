import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                }

                char c = st.pop();

                if (ch == ')' && c != '(') {
                    return false;
                }

                if (ch == '}' && c != '{') {
                    return false;
                }

                if (ch == ']' && c != '[') {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();

        System.out.println(obj.isValid("()"));       // true
        System.out.println(obj.isValid("()[]{}"));   // true
        System.out.println(obj.isValid("(]"));       // false
        System.out.println(obj.isValid("([)]"));     // false
        System.out.println(obj.isValid("{[]}"));     // true
    }
}