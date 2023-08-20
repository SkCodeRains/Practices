import java.util.Arrays;

public record P0014SingleNumer() {
    public static void main(String[] args) {
        int nums[] = { 4, 1, 2, 1, 1, 1, 2, 2, 2, 2, 1, 2 };
        int single = singleNumber(nums);
        System.out.println(single);
    }

    private static int singleNumber(int[] nums) {
        int size = nums.length;
        int answer = -1;
        Arrays.sort(nums);
        for (int i = 0; i < size; i = i + 2) {
            if (i == (size - 1)) {
                answer = nums[i];
            } else if (nums[i] != nums[i + 1]) {
                answer = nums[i];
                break;
            }
        }
        return answer;
    }
}
