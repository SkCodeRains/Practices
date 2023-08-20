public class P0019HighestAltitude {
    public static int findHighestAltitude(int[] gain) {
        int alt = 0;
        int sum = 0;

        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            alt = Math.max(alt, sum);
        }

        return alt;
    }

    public static void main(String[] args) {
        int[] gain = { -5, 1, 5, 0, -7 };
        int result = findHighestAltitude(gain);
        System.out.println("Highest Altitude: " + result);
    }

}
