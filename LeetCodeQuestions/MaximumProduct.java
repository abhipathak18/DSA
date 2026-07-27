public class MaximumProduct {

    public int maxProduct(int[] nums) {

        int maxProduct = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                int product = (nums[i] - 1) * (nums[j] - 1);
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {

        MaximumProduct solution = new MaximumProduct();

        int[] nums = {3, 4, 5, 2};

        System.out.println(solution.maxProduct(nums));
    }
}