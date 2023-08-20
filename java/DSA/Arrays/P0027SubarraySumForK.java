public class P0027SubarraySumForK {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 0 };
        int k = 1;
        int result = subarraySum(nums, k);
        System.out.println(result);
    }

    public static int subarraySum(int[] nums, int k) {
        // Your code goes here
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }

        }
        return count;
    }
}
