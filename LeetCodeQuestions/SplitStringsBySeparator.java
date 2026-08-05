import java.util.ArrayList;
import java.util.List;

public class SplitStringsBySeparator {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            StringBuilder currentWord = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (ch == separator) {
                    if (currentWord.length() > 0) {
                        result.add(currentWord.toString());
                        currentWord.setLength(0);
                    }
                } else {
                    currentWord.append(ch);
                }
            }

            if (currentWord.length() > 0) {
                result.add(currentWord.toString());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SplitStringsBySeparator splitter = new SplitStringsBySeparator();

        List<String> words = List.of("one.two.three", "four.five", "six");

        List<String> result = splitter.splitWordsBySeparator(words, '.');

        System.out.println(result);
    }
}