import java.util.Arrays;

public class P0007ReversingArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        reverseArray(arr);
    }

    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            /**
             * swapping the value
             */
            arr[start] += arr[end];
            arr[end] = arr[start] - arr[end];
            arr[start] -= arr[end];

            start++;
            end--;

        }
        String stringArr = Arrays.toString(arr);
        System.out.println("Array: " + stringArr);
    }
}
