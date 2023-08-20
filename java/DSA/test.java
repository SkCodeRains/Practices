public class test {

    public static void main(String[] args) {
        // Capture the start time
        long startTime = System.nanoTime();

        // Call the code you want to measure
        long result = yourProgramLogic();

        // Capture the end time
        long endTime = System.nanoTime();

        // Calculate the elapsed time
        long elapsedTime = endTime - startTime;

        // Print the result and elapsed time
        System.out.println("Result: " + result);
        System.out.println("Elapsed Time (nanoseconds): " + elapsedTime);
        double milliseconds=(elapsedTime / 1000000.0);
        System.out.println("Elapsed Time (milliseconds): " + milliseconds);
        System.out.println("Elapsed Time (second): " + (milliseconds / 1000.0));

    }

    public static long yourProgramLogic() {
        // Your code that you want to measure
        long total = 0;
        long index=9999999999l;
        for (long i = 1; i <= index ; i++) {
            long a=i;
            a=a*a;
            total += i;
        }
        return total;
    }
}
