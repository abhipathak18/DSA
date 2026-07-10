public class NimGame {

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        int n = 4;

        if (canWinNim(n)) {
            System.out.println("Player can win.");
        } else {
            System.out.println("Player cannot win.");
        }
    }
}
