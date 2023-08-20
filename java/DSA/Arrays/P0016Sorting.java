import java.util.Arrays;

public class P0016Sorting {
    public static void main(String[] args) {

        int nums[] = { 0, 1, 2, 0, 0, 2, 0, 0, 1, 0, 1, 1, 2, 1, 2, 1 };
        int largeSum[] = sort(nums);
        System.out.println(Arrays.toString(largeSum));
    }

    private static int[] sort(int[] nums) {

        int zeros = 0, ones = 0, twos = 0;
        for (int i : nums) {
            if (i == 0) {
                zeros++;
            } else if (i == 1) {
                ones++;
            } else if (i == 2) {
                twos++;
            }
        }
        int index = 0;
        while (zeros > 0) {
            nums[index++] = 0;
            zeros--;
        }
        while (ones > 0) {
            nums[index++] = 1;
            ones--;
        }
        while (twos > 0) {
            nums[index++] = 2;
            twos--;
        }
        return nums;
    }
}
