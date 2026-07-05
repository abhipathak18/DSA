import java.util.ArrayList;
import java.util.List;

public class BuildArray {

    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int curr = 1;

        for (int num : target) {
            while (curr < num) {
                result.add("Push");
                result.add("Pop");
                curr++;
            }

            result.add("Push");
            curr++;
        }

        return result;
    }

    // Driver Code
    public static void main(String[] args) {

        BuildArray obj = new BuildArray();

        int[] target = {1, 3};
        int n = 3;

        List<String> operations = obj.buildArray(target, n);

        System.out.println("Operations:");
        for (String operation : operations) {
            System.out.println(operation);
        }
    }
}