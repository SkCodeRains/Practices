package Numbers;

import java.util.Arrays;

public class P002FindGCD {
    public static void main(String[] args) {
        int[] nums = { 7, 5, 6, 8, 3 };
        int ans = findGCD(nums);
        System.out.println(ans);
    }

    private static int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n = nums[nums.length - 1];
        int result = nums[0];
        while (result > 0) {
            if (nums[0] % result == 0 && n % result == 0) {
                break;
            }
            result--;
        }
        return result;
    }
}
