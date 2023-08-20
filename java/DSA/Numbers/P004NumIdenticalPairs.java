package Numbers;

public class P004NumIdenticalPairs {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1, 1, 3 };
        int ans = numIdenticalPairs(nums);
        System.out.println(ans);
    }

    private static int numIdenticalPairs(int[] nums) {
        int size = nums.length;
        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}