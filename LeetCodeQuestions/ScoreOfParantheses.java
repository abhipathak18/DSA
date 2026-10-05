import java.util.Stack;

public class ScoreOfParantheses {

    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentScore = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Push the current score to save the context of the outer layer
                stack.push(currentScore);
                // Reset score for the inner layer
                currentScore = 0;
            } else {
                // When meeting ')', calculate the score of the completed inner layer
                // If currentScore is 0, it means it was a primitive "()", which scores 1.
                // Otherwise, it is a nested structure like "(A)", which scores 2 * A.
                currentScore = stack.pop() + Math.max(2 * currentScore, 1);
            }
        }

        return currentScore;
    }

    // Main method added to allow execution in VS Code
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
