import java.util.Scanner;

class GetListOfPerfectNumbers {

    public static void main(String[] args) {

        System.out.print("Please enter the number to 0 to between find the perfect number");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        long count = 0;
        for (int i = 1; i <= number; i++) {
            int sum = 0;
            for (int j = 1; j <= (i / 2); j++) {
                count++;
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                System.out.println(sum + " is perfect number");
            }
        }

        System.out.println("Count Ran : " + count);

        sc.close();

    }

}
