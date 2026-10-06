import java.util.Stack;

public class ScoreOfParantheses {

    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentScore = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(currentScore);
                currentScore = 0;
            } else {
                currentScore = stack.pop() + Math.max(2 * currentScore, 1);
            }
        }

        return currentScore;
    }

    public static void main(String[] args) {
        ScoreOfParantheses solution = new ScoreOfParantheses();

        // Test Cases
        String test1 = "()";
        String test2 = "(())";
        String test3 = "()()";
        String test4 = "(()(()))";

        System.out.println("Score of " + test1 + ": " + solution.scoreOfParentheses(test1)); // Output: 1
        System.out.println("Score of " + test2 + ": " + solution.scoreOfParentheses(test2)); // Output: 2
        System.out.println("Score of " + test3 + ": " + solution.scoreOfParentheses(test3)); // Output: 2
        System.out.println("Score of " + test4 + ": " + solution.scoreOfParentheses(test4)); // Output: 6
    }
}
