import java.util.Scanner;

public class NumberOfSteps {

    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;

            if (bit == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps += 1;
            }
        }

        return steps + carry;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String s = sc.next();

        NumberOfSteps obj = new NumberOfSteps();
        int result = obj.numSteps(s);

        System.out.println("Nmber of steps: " + result);

        sc.close();
    }
}