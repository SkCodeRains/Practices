import java.util.ArrayList;
import java.util.List;

public class FindDevisors {

    public static void main(String[] args) {
        int number = 4;
        List<Integer> divisors = getDivisors(number);

        System.out.println("Divisors of " + number + ":");
        for (int divisor : divisors) {
            System.out.print(divisor + " ");
        }
    }

    private static List<Integer> getDivisors(int number) {

        List<Integer> divisor = new ArrayList<>();
       

        for (int i = 1; i*i <= number ; i++) {  // 12 
            if (number % i == 0) {

                if (i != number / i) {
                    divisor.add(number / i);
                }
                divisor.add(i);
            }
        }

        return divisor;
    }

  
 }
    