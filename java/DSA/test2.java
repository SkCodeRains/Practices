public class test2 {
    public static void main(String[] args) {
        int n = 25;
        int[] fib = new int[n + 1];
        if (n > 2) {
            fib[0] = 0;
            fib[1] = 1;
            fib[2] = 1;
            for (int count = 3; count < fib.length; count++) {
                fib[count] = fib[count - 2] + fib[count - 1];
            }
        } else {
            System.out.println(n == 0 ? 0 : 1);
            return;
        }
        System.out.println(fib[n]);
    }
}
