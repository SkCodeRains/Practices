public class P0024NumOfSubarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        for (int i = k; i <= arr.length; i++) {
            if (sum / k >= threshold) {
                count++;
            }

            if (i == arr.length) {
                break;
            }

            sum += arr[i];
            sum -= arr[i - k];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 2, 2, 5, 5, 5, 8 };
        int k = 3;
        int threshold = 4;

        P0024NumOfSubarrays solution = new P0024NumOfSubarrays();
        int result = solution.numOfSubarrays(arr, k, threshold);

        System.out.println("Number of sub-arrays: " + result);
    }
}
