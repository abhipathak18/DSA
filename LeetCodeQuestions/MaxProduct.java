import java.util.Scanner;

public class MaxProduct {

    public int maxProduct(int n) {
        int largest = 0;
        int secondLargest = 0;

        while (n > 0) {
            int digit = n % 10;

            if (digit >= largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest) {
                secondLargest = digit;
            }

            n /= 10;
        }

        return largest * secondLargest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        MaxProduct obj = new MaxProduct();
        int result = obj.maxProduct(n);

        System.out.println("Maximum product of two largest digits: " + result);

        sc.close();
    }
}