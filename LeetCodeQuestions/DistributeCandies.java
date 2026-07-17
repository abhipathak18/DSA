import java.util.HashSet;

public class DistributeCandies {

    public static int distributeCandies(int[] candyType) {

        HashSet<Integer> set = new HashSet<>();

        for (int candy : candyType) {
            set.add(candy);
        }

        return Math.min(candyType.length / 2, set.size());
    }

    public static void main(String[] args) {

        int[] candyType = {1, 1, 2, 2, 3, 3};

        int result = distributeCandies(candyType);

        System.out.println("Maximum Different Candies = " + result);
    }
}