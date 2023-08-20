import java.util.Arrays;

public class P0009MovesZeros {

    public static void main(String[] args) {
        Integer[] nums = { 2, 1 };

        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length && nums.length > 1; i++) {

            if (nums[i] == 0 && nums[nonZeroIndex] != 0) {
                nonZeroIndex = i;
                continue;
            }

            if (nums[nonZeroIndex] != 0 && nums[i] != 0) {
                continue;
            }

            if (nums[i] != 0 && i > nonZeroIndex) {
                nums[nonZeroIndex] += nums[i];
                nums[i] = nums[nonZeroIndex] - nums[i];
                nums[nonZeroIndex] -= nums[i];

                nonZeroIndex++;
            }
        }

        System.out.println(Arrays.asList(nums));
    }

}
