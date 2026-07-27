import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {

    private final Set<String> set = new HashSet<>();
    private final HashMap<String, Boolean> memo = new HashMap<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> list = new ArrayList<>();

        for (String word : words) {
            set.add(word);
        }

        for (String word : words) {
            memo.clear();
            set.remove(word);

            if (con(word)) {
                list.add(word);
            }

            set.add(word);
        }

        return list;
    }

    private boolean con(String word) {

        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        for (int i = 1; i < word.length(); i++) {

            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (set.contains(prefix)
                    && (set.contains(suffix) || con(suffix))) {

                memo.put(word, true);
                return true;
            }
        }

        memo.put(word, false);
        return false;
    }

    public static void main(String[] args) {

        ConcatenatedWords solution = new ConcatenatedWords();

        String[] words = {
                "cat",
                "cats",
                "catsdog",
                "dog",
                "dogcatsdog",
                "hippopotamuses",
                "rat",
                "ratcatdogcat"
        };

        List<String> result = solution.findAllConcatenatedWordsInADict(words);

        System.out.println(result);
    }
}