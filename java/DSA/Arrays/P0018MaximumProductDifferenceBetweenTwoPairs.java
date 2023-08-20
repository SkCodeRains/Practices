import java.util.Arrays;

public class P0018MaximumProductDifferenceBetweenTwoPairs {
    public static void main(String[] args) {
        int nums[] = {};
        int ans = maxDifference(nums);
    }

    private static int maxDifference(int[] nums) {
        Arrays.sort(nums);
        int prod1 = nums[0] * nums[1];
        int prod2 = nums[nums.length - 1] * nums[nums.length - 2];
        return prod2 - prod1;
    }
}
