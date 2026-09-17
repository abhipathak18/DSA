import java.util.*;

public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            row.add(1);

            for (int j = 1; j < i; j++) {
                int value = result.get(i - 1).get(j - 1)
                         + result.get(i - 1).get(j);

                row.add(value);
            }

            if (i > 0) {
                row.add(1);
            }

            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        int numRows = 5;

        List<List<Integer>> answer = generate(numRows);

        System.out.println(answer);
    }
}