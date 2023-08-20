import java.util.Scanner;

class FindThePerfectNumber {
    public static void main(String[] args) {
        System.out.println("Please enter the number to find number is Perfect or not");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        if (sum == number) {
            System.out.println(number + " is perfect number");
        } else {
            System.out.println(number + " is not perfect number");
        }
        sc.close();
    }
}
