import java.util.Arrays;

public class ReorderDataInLogFiles {

    public static void main(String[] args) {
        String[] logs = {
            "dig1 8 1 5 1",
            "let1 art can",
            "dig2 3 6",
            "let2 own kit dig",
            "let3 art zero"
        };

        String[] result = reorderLogFiles(logs);

        for (String log : result) {
            System.out.println(log);
        }
    }

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            int idx1 = a.indexOf(' ');
            int idx2 = b.indexOf(' ');

            String id1 = a.substring(0, idx1);
            String id2 = b.substring(0, idx2);

            String content1 = a.substring(idx1 + 1);
            String content2 = b.substring(idx2 + 1);

            boolean isDigit1 = Character.isDigit(content1.charAt(0));
            boolean isDigit2 = Character.isDigit(content2.charAt(0));

            // Both are letter logs
            if (!isDigit1 && !isDigit2) {
                int cmp = content1.compareTo(content2);
                if (cmp != 0) {
                    return cmp;
                }
                return id1.compareTo(id2);
            }

            // Letter logs come before digit logs
            if (!isDigit1 && isDigit2) {
                return -1;
            }

            if (isDigit1 && !isDigit2) {
                return 1;
            }

            // Both digit logs: keep original order
            return 0;
        });

        return logs;
    }
}