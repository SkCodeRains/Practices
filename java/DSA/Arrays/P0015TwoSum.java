import java.util.Arrays;

public class P0015TwoSum {
    public static void main(String[] args) {
        int nums[] = { 2, 7, 11, 15 };
        int largeSum[] = twoSum(nums, 9);
        System.out.println(Arrays.toString(largeSum));
    }

    private static int[] twoSum(int[] nums, int target) {
        int answer[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        return answer;
    }
}
