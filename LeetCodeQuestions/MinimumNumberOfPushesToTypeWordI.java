// File: MinimumNumberOfPushesToTypeWordI.java

public class MinimumNumberOfPushesToTypeWordI {

    public static int minimumPushes(String word) {
        int n = word.length();
        int pushes = 0;

        // Every group of 8 characters requires one extra push
        for (int i = 0; i < n; i++) {
            pushes += (i / 8) + 1;
        }

        return pushes;
    }

    public static void main(String[] args) {

        String word1 = "abcde";
        String word2 = "abcdefghij";
        String word3 = "abcdefghijklmnop";

        System.out.println("Word: " + word1);
        System.out.println("Minimum Pushes = " + minimumPushes(word1));

        System.out.println();

        System.out.println("Word: " + word2);
        System.out.println("Minimum Pushes = " + minimumPushes(word2));

        System.out.println();

        System.out.println("Word: " + word3);
        System.out.println("Minimum Pushes = " + minimumPushes(word3));
    }
}