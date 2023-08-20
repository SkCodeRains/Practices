package Numbers;

public class P001ThreeDiverse {
    public static void main(String[] args) {
        boolean ans = isThree(5);
        System.out.println(ans);

    }

    private static boolean isThree(int i) {
        int count = 0;
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) {
                count++;
            }
        }

        return count >= 3;
    }
}
