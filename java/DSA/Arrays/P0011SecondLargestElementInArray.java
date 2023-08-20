
public class P0011SecondLargestElementInArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 4, 6, 5, 11, 15 };

        int large1 = Integer.MIN_VALUE;
        int large2 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (large1 < nums[i]) {
                large2 = large1;
                large1 = nums[i];
            } else if (nums[i] < large2 && large1 != nums[i]) {
                large2 = nums[i];
            }
        }
        System.out.println(large2);
    }

}
