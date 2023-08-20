import java.util.Scanner;

/**
 * Program for getting the Sum Of the Giving number
 */
class FindSumOfTheNumber {
    public static void main(String[] args) {

        System.out.println("Please enter the number to find the sum");

        int number = (new Scanner(System.in).nextInt());
        int sum = 0;
        while (number != 0) {
            /* taking the last digit and doing sume */
            sum += number % 10;

            /* removing the last digit so that we can add another digit in next loop */
            number = number / 10;
        }

        System.out.println(sum);
    }
}