public class P0018MaximumDifferenceofzerosandonesinaBinaryString {
    public static void main(String[] args) {

        int ans = maxDifference("11");
        System.out.println(ans);
    }

    private static int maxDifference(String s) {

        char[] chars = s.toCharArray();

        int zeros = 0;
        int bag = 0;
        for (int i = 0; i < chars.length; i++) {
            int x = Character.getNumericValue(chars[i]);
            if (x == 0) {
                bag++;
            } else {
                bag--;
            }
            if (chars.length - 1 <= i && zeros == 0) {
                zeros = bag;
                break;
            }
            if (bag > zeros) {
                zeros = bag;
            }
            if (bag < 0) {
                bag = 0;
            }

        }

        return zeros;
    }
}
