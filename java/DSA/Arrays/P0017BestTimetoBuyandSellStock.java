public class P0017BestTimetoBuyandSellStock {
    public static void main(String[] args) {

        int nums[] = { 7, 2, 15, 1, 6, 4, 0 };
        int ans = maxProfit(nums);
        System.out.println(ans);
    }

    private static int maxProfit(int[] prices) {

        int buy = prices[0];
        int assume = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                assume = prices[i] - buy;
                maxProfit = Math.max(maxProfit, assume);
            } else {
                buy = prices[i];
            }
        }

        return maxProfit;
    }

    private static int maxProfit2(int[] nums) {
        int maxProfit = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count++;
                int x = nums[j] - nums[i];
                if (x > maxProfit) {
                    maxProfit = x;
                }
            }
        }
        System.out.println(count);
        return maxProfit;
    }
}