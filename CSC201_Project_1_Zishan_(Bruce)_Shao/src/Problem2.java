import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {

        /* The program will return the total time costs of two different algorithms with O(n) and O(n^2)
         * complexity.
         */

        // Use the scanner to acquisite the number of inputs for both snippets
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the number of the inputs for Snippet 1: ");
        int numInputs1 = sc.nextInt();
        System.out.print("Please enter the number of the inputs for Snippet 2: ");
        int numInputs2 = sc.nextInt();

        long time1 = Snippet1(numInputs1);
        long time2 = Snippet2(numInputs2);

        System.out.println(time1);
        System.out.println(time2);
    }

    // return the time cost of the Snippet 1
    public static long Snippet1(int n) {
        long timeCost1 = 0;

        long start_time = System.nanoTime();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + i;
        }

        long end_time = System.nanoTime();
        timeCost1 = end_time - start_time;


        return timeCost1;
    }

    // return the time cost of the Snippet 2
    public static long Snippet2(int n) {
        long timeCost2 = 0;

        long start_time2 = System.nanoTime();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i*i; j++) {
                sum = sum + i;
            }
        }

        long end_time2 = System.nanoTime();
        timeCost2 = end_time2 - start_time2;


        return timeCost2;
    }
}
