import java.util.Scanner;

class FindThePrimNumber {
    public static void main(String[] args) {
        System.out.println("Please enter the number to find prime or not");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        boolean isPrime = false;
        if (number < 3) {
            isPrime = true;
        }
        for (int i = 2; i * i < number; i++) {
            if (number % i != 0) {
                isPrime = true;
                break;
            }
        }
        if (isPrime) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
        sc.close();
    }
}
