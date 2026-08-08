    import java.util.*;

public class DestinationCity {

    // Finds the city that is not a starting city.
    // That city is the final destination.
    public static String destCity(List<List<String>> paths) {

        // Store all cities from which we can travel.
        HashSet<String> fromCities = new HashSet<>();

        for (List<String> path : paths) {
            // path.get(0) = starting city
            fromCities.add(path.get(0));
        }

        // Check every destination city.
        for (List<String> path : paths) {
            // path.get(1) = destination city
            String destination = path.get(1);

            // If this city is never a starting city,
            // it is the final destination.
            if (!fromCities.contains(destination)) {
                return destination;
            }
        }

        return "";
    }

    public static void main(String[] args) {

        // Sample input
        List<List<String>> paths = new ArrayList<>();

        paths.add(Arrays.asList("London", "New York"));
        paths.add(Arrays.asList("New York", "Lima"));
        paths.add(Arrays.asList("Lima", "Sao Paulo"));

        // Find the destination city
        String result = destCity(paths);

        // Print result
        System.out.println("Destination City: " + result);
    }
}