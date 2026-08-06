public class SmallestDivisibleDigitProduct {

    // Returns the smallest number >= n
    // whose digit product is divisible by t.
    public static int smallestNumber(int n, int t) {
        while (true) {
            if (digitProduct(n) % t == 0) {
                return n;
            }
            n++;
        }
    }

    // Computes the product of the digits of a number.
    private static int digitProduct(int num) {
        int product = 1;

        // Special case for 0
        if (num == 0) {
            return 0;
        }

        while (num > 0) {
            product *= (num % 10);
            num /= 10;
        }

        return product;
    }

    public static void main(String[] args) {
        int n = 13;
        int t = 4;

        int result = smallestNumber(n, t);

        System.out.println("Smallest Number: " + result);
    }
}