 
class ReverseTheGivenNumber {
    public static void main(String[] args) {
 
        ReverseTheGivenNumber reverseNumberObj = new ReverseTheGivenNumber();
        int reverseNumber = reverseNumberObj.getReverseNumber(1056389759);
        System.out.println(reverseNumber);
    }

    public int getReverseNumber(int number) {
        int reverseNumber = 0;
        while (number != 0) {
            /* finding the last digit */
            int digit = number % 10;

            /**
             * multiplying the reverseNumber with 10
             * and adding the last digit
             * for example 12345
             * in first 0*10=0 and last digit 5 , 0+5 will be five
             * so 5 will be assigned to reverseNumber
             * and then removing the last diggit
             * \
             * in second loop number will be 1234
             * so last digit will be 4
             * 5*10+4 = 54
             * and removing the last digit then
             * 
             * now process will run until the number become 0
             * 
             * and we will have 54321
             */
            reverseNumber = reverseNumber * 10 + digit;

            /* removing the last digit */
            number = number / 10;
        }
        return reverseNumber;
    }
}
