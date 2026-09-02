public class UniformArray {

    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for (int num : nums1) {
            min = Math.min(min, num);

            if (num % 2 != 0) {
                minOdd = Math.min(minOdd, num);
            }
        }
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }
        return min % 2 != 0 || minOdd > min;
    }

    public static void main(String[] args) {
        UniformArray solution = new UniformArray();

        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        int[] nums3 = {1, 2, 3};

        System.out.println(solution.uniformArray(nums1));
        System.out.println(solution.uniformArray(nums2));
        System.out.println(solution.uniformArray(nums3));
    }
}