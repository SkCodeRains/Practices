
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0022FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < n - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int left = j + 1;
                        int right = n - 1;

                        while (left < right) {
                            int sum = nums[i] + nums[j] + nums[left] + nums[right];

                            if (sum == target) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                                while (left < right && nums[left] == nums[left + 1])
                                    left++;
                                while (left < right && nums[right] == nums[right - 1])
                                    right--;

                                left++;
                                right--;
                            } else if (sum < target) {
                                left++;
                            } else {
                                right--;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        P0022FourSum solution = new P0022FourSum();
        List<List<Integer>> result = solution.fourSum(nums, target);

        // Print the result
        for (List<Integer> quadruplet : result) {
            System.out.println(quadruplet);
        }
    }
}
