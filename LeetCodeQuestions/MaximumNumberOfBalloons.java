// File: MaximumNumberOfBalloons.java

public class MaximumNumberOfBalloons {

    public static int maxNumberOfBalloons(String text) {

        int[] count = new int[26];

        // Count frequency of each character
        for (char ch : text.toCharArray()) {
            count[ch - 'a']++;
        }

        int b = count['b' - 'a'];
        int a = count['a' - 'a'];
        int l = count['l' - 'a'] / 2; // 'l' appears twice
        int o = count['o' - 'a'] / 2; // 'o' appears twice
        int n = count['n' - 'a'];

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }

    public static void main(String[] args) {

        String text1 = "nlaebolko";
        String text2 = "loonbalxballpoon";
        String text3 = "leetcode";

        System.out.println("Input: " + text1);
        System.out.println("Output: " + maxNumberOfBalloons(text1));
        System.out.println();
        System.out.println("Input: " + text2);
        System.out.println("Output: " + maxNumberOfBalloons(text2));
        System.out.println();
        System.out.println("Input: " + text3);
        System.out.println("Output: " + maxNumberOfBalloons(text3));
    }
}