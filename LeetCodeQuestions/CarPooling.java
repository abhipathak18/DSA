public class CarPooling {

    public static boolean carPooling(int[][] trips, int capacity) {

        int[] diff = new int[1001];

        for (int[] trip : trips) {

            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            diff[from] += passengers;
            diff[to] -= passengers;
        }

        int current = 0;

        for (int i = 0; i < 1001; i++) {

            current += diff[i];

            if (current > capacity) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] trips = {
                {2, 1, 5},
                {3, 3, 7}
        };

        int capacity = 4;

        boolean result = carPooling(trips, capacity);

        System.out.println(result);
    }
}