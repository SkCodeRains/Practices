import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P008RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2, 3,3,4,4, 14));
        P008RemoveDuplicates obj = new P008RemoveDuplicates();

        System.out.println(obj.removeDuplicates(list).toString());
        ;

    }

    public List<Integer> removeDuplicates(List<Integer> nums) {
        // Your code goes here
        int size = nums.size();
        int i = 0;
        List<Integer> answer = new ArrayList<>();

        while (i < size) {
            int temp = nums.get(i);
            while (i < size && temp == nums.get(i)) {
                i++;
            }
            answer.add(nums.get(i-1));
        }

        return answer;
    }
}
