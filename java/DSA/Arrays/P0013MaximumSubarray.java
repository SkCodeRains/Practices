public class P0013MaximumSubarray {
    public static void main(String[] args) {
        int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int maxSum = maximumSubarray(nums);
        System.out.println(maxSum);

    }

    private static int maximumSubarray(int[] nums) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i : nums) {
            sum += i;
            maxSum = sum > maxSum ? sum : maxSum;
            sum = sum < 0 ? 0 : sum;

        }

        return maxSum;
    }
}
