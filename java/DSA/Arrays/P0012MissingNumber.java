public class P0012MissingNumber {
    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };

        System.out.println(missingNumber(nums));
    }

    private static int missingNumber(int[] nums) {
        int totalSum = nums.length * (nums.length + 1) / 2;
        int missingNumber = 0;
        for (int i : nums) {
            missingNumber += i;
        }
        return totalSum - missingNumber;
    }
}
