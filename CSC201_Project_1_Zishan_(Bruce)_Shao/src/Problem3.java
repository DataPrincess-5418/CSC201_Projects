import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(" ");
        int[] inputs = new int[array.length];

        // main loop 1
        for (int i = 0; i < array.length; ++i) {

            // Use the try-catch to avoid syntax error caused by misinputting non-numerical inputs
            try {
                inputs[i] = Integer.parseInt(array[i]);
            } catch (NumberFormatException ex) {
                System.out.print("Input error");
                System.exit(0);
            }
        }

        int[] sorted = bbsort(inputs);

        // main loop 3
        for (int i = 0; i < sorted.length; ++i) {
            System.out.print(sorted[i] + " ");
        }
    }

    public static int[] bbsort(int[] unso) {

        int[] good = unso;

        /* In this method, we employed the bubble sort algorithm, with O(n^2) complexity,
         * to accomplish our goal. The method will return the sorted array of integers.
         */

        //main loop 2
        for (int i = 0; i < unso.length - 1; ++i) {
            for (int j = 0; j < unso.length - 1; ++j) {
                if (good[j] >= good[j+1]) {
                    // exchange unso[j] with unso[j+1]
                    int tmp = good[j];
                    good[j] = good[j + 1];
                    good[j + 1] = tmp;
                }
            }
        }

        return good;
    }
}
