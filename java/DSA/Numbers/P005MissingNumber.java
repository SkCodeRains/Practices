package Numbers;

public class P005MissingNumber {
    public static void main(String[] args) {
        int nums[] = { 3, 0, 1 };
        int ans = missingNumber(nums);
        System.out.println(ans);
    }

    private static int missingNumber(int[] nums) {
        int size = nums.length;
        int totalSum = size * (size + 1) / 2;
        int actualSum = 0;
        for (int i : nums) {
            actualSum += i;
        }

        return totalSum - actualSum;
    }

}