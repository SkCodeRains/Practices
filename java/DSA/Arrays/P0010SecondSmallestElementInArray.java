
public class P0010SecondSmallestElementInArray {
    public static void main(String[] args) {
        int[] nums = { -5, -1, 0, 1, 2, 1, 4, 6, 5, 11, 15, };

        int small1 = nums[0];
        int small2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (small1 > nums[i]) {
                small2 = small1;
                small1 = nums[i];
            } else if (nums[i] < small2 && small1 != nums[i]) {
                small2 = nums[i];
            }
        }

        System.out.println(small2);
    }

}
