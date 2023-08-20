package Numbers;

import java.util.*;

public class P007SwapTwoNumbers {

    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>(swap(5, 3));
        System.out.println(ans);
    }

    private static List<Integer> swap(int a, int b) {
        List<Integer> ans = new ArrayList<>();

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        ans.add(a);
        ans.add(b);

        return ans;
    }
}
