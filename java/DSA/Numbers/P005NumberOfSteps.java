package Numbers;

public class P005NumberOfSteps {
    public static void main(String[] args) {

        int ans = numberOfSteps(14);
        System.out.println(ans);
    }

    private static int numberOfSteps(int num) {
        int count = 0;

        while (num > 0) {

            if (num % 2 == 0) {
                num = num / 2;

            } else {
                num--;
            }
            count++;
        }

        return count;
    }

}
