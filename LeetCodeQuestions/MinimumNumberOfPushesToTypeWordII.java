import java.util.Arrays;

public class MinimumNumberOfPushesToTypeWordII {

    public int minimumPushes(String word) {
        int[] frequency = new int[26];

        // Count frequency of each character
        for (char ch : word.toCharArray()) {
            frequency[ch - 'a']++;
        }

        // Sort frequencies
        Arrays.sort(frequency);

        int minimumPushes = 0;
        int assignedLetters = 0;
        // Assign lowest push counts to highest frequencies
        for (int i = 25; i >= 0; i--) {
            if (frequency[i] == 0) {
                break;
            }

            int pushesRequired = (assignedLetters / 8) + 1;
            minimumPushes += frequency[i] * pushesRequired;
            assignedLetters++;
        }

        return minimumPushes;
    }

    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWordII solver =
                new MinimumNumberOfPushesToTypeWordII();

        System.out.println(solver.minimumPushes("abcabc")); // 6
    }
}