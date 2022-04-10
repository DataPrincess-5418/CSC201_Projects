public class Problem_1 {

    public static void main(String[] args) {

        // declare the array for testing
        int[] arr = new int[]{10,3,5,8,7,6};
        // int[] arr = new int[]{2,7,3,4,10,9,23};
        //int[] arr = new int[]{2,5,8,1,4,9,0};

        // print out the array
        printArray(arr, arr.length);

        Quicksort qs = new Quicksort();

        // sort and print the sorted array
        qs.my_quicksort(arr);
        printArray(arr, arr.length);
    }

    // printArray: Print all the elements in array
    public static void printArray(int[] arr, int size)
    {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
