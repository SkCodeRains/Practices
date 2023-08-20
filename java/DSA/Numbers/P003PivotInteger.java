package Numbers;

public class P003PivotInteger {
    public static void main(String[] args) {
        int ans = pivotInteger(8);
        System.out.println(ans);
    }

    private static int pivotInteger(int n) {
        int sum = 0;
        int total = n * (n + 1) / 2;

        for (int j = 1; j <= n; j++) {
            sum += j;
            if (total - sum + j == sum) {
                return j;
            }
        }

        return -1;

    }
}
