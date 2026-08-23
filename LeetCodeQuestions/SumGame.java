public class SumGame {
    public boolean sumGame(String num) {
        int n = num.length();
        int mid = n / 2;
        
        int s1 = 0, q1 = 0;
        int s2 = 0, q2 = 0;
        
        for (int i = 0; i < mid; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                q1++;
            } else {
                s1 += c - '0';
            }
        }
        
        for (int i = mid; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                q2++;
            } else {
                s2 += c - '0';
            }
        }
        
        return 2 * (s1 - s2) + 9 * (q1 - q2) != 0;
    }

    public static void main(String[] args) {
        SumGame solver = new SumGame();

        // Example 1 (Expected output: false)
        String test1 = "5023";
        System.out.println("Test 1 (" + test1 + "): " + solver.sumGame(test1));

        // Example 2 (Expected output: true)
        String test2 = "25??";
        System.out.println("Test 2 (" + test2 + "): " + solver.sumGame(test2));
    }
}
