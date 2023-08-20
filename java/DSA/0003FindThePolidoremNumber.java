import java.util.Scanner;

class FindThePolidoremNumber {
    public static void main(String[] args) {

        System.out.println("Please enter the number to find the sum");

        int number = (new Scanner(System.in).nextInt());

        boolean isPolindorem = isPolindorem(number);
        if (isPolindorem) {
            System.out.println("Given Number : " + number + " is polidorem");
        } else {
            System.out.println("Given Number : " + number + " is not polidorem");
        }
    }

    public static boolean isPolindorem(int number) {
        ReverseTheGivenNumber reverseNumberObj = new ReverseTheGivenNumber();
        int reverseNumber = reverseNumberObj.getReverseNumber(number);
        return reverseNumber == number;
    }
}
