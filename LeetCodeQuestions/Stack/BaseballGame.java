import java.util.Stack;

public class BaseballGame {

    public static int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < operations.length; i++) {

            if (operations[i].equals("+")) {

                int a = stack.pop();
                int b = stack.peek();

                stack.push(a);
                stack.push(a + b);

            } else if (operations[i].equals("C")) {

                stack.pop();

            } else if (operations[i].equals("D")) {

                int a = stack.peek();
                stack.push(2 * a);

            } else {

                stack.push(Integer.parseInt(operations[i]));
            }
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {

        String[] operations = {"5", "2", "C", "D", "+"};

        System.out.println("Total Score = " + calPoints(operations));
    }
}