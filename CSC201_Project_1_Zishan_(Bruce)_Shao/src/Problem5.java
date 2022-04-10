import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split(" ");

        //if inputs are empty array, print error and exit the system
        if (array == null) {
            System.out.print("Error: Empty Inputs");
            System.exit(0);
        }

        int[] inputs = new int[array.length];

        for (int i = 0; i < array.length; ++i) {

            // Use the try-catch to avoid syntax error caused by misinputting non-numerical inputs
            try {
                inputs[i] = Integer.parseInt(array[i]);
            } catch (NumberFormatException ex) {
                System.out.print("Input error");
                System.exit(1);
            }
        }

        // Acquisite the value to be found from the array
        System.out.print("The value to be found: ");
        int tofind = sc.nextInt();

        int isIn = btSearch(inputs, 0, ((inputs.length) - 1), tofind);

        if (isIn == -1) {
            System.out.println("The number is not in the array");
        }
        else {
            System.out.println("The number is in the array");
        }
    }


    // We apply the binary search method to determine:
    // 1. If the parameter x exist in the array
    // 2, The position of the parameter x in the array
    public static int btSearch(int[] sar, int start, int end, int x) {

        // as long as end is larger than start, the search continues
        if (end >= start) {
            int mid = start + (end - start) / 2;

            // Case 1: parameter x is found in the array, return the index of the element
            if (sar[mid] == x) {
                return mid;
            }
            // Case 2: the midpoint is larger than x, indicating we should search among
            // right-side of the array, so we set the start point with mid + 1
            else if (sar[mid] > x) {
                 return btSearch(sar, mid + 1, end, x);
            }
            // Case 3: the midpoint is smaller than x, indicating we should search among
            // left-side of the array, so we set the start point with mid + 1
            else {
                return btSearch(sar, start, mid - 1, x);
            }
        }

        // If element is not in array, return -1
        return -1;
    }
}
