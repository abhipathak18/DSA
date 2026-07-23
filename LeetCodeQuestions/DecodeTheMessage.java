public class DecodeTheMessage {

    public static String decodeMessage(String key, String message) {

        char[] map = new char[26];
        boolean[] visited = new boolean[26];

        char ch = 'a';

        // Build mapping
        for (char c : key.toCharArray()) {

            if (c != ' ' && !visited[c - 'a']) {
                visited[c - 'a'] = true;
                map[c - 'a'] = ch;
                ch++;
            }
        }

        // Decode message
        StringBuilder ans = new StringBuilder();

        for (char c : message.toCharArray()) {

            if (c == ' ') {
                ans.append(' ');
            } else {
                ans.append(map[c - 'a']);
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";

        System.out.prntln(decodeMessage(key, message));
    }
}