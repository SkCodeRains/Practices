import java.util.Arrays;

public class P0020MajorityElement {
    public static void main(String[] args) {
        int[] gain = { 3,2,3 };
        int ans = majorityElement(gain);
        System.out.println(ans);
    }

    private static int majorityElement(int[] nums) {

        Arrays.sort(nums);

        return nums[(nums.length / 2)];
    }
}
