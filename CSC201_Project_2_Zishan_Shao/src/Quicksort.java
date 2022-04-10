public class Quicksort {
    public void my_quicksort(int[] array){

        // define pointers
        int low = 0;
        int high = array.length - 1;

        quicksort_helper(array, low, high);

    }
    private void quicksort_helper(int[] array, int low, int high){

        // define the base case: single element array
        // At the mean time, condition array == null avoid potential error of inputting null array
        if (array == null || low >= high) {
            return;
        }

        // partition will return the final position of the pivot, and thus we could
        // apply recursion on subarray on left and right sides of the pivot
        int p = partition(array, low, high);

        // the left part of pivot, elements larger than pivot
        quicksort_helper(array, low,p - 1);

        // the right part of pivot, elements smaller than pivot
        quicksort_helper(array, p + 1, high);

    }

    // partition method will swap the elements inside array based on the value of pivot
    private int partition(int[] array, int low, int high){

        // define pivot
        int pivot = array[low];

        // record the length of the subarray/array
        // record the pivot position p
        int len = high;
        int p = low;

        // renew the low
        low = low + 1;

        // as long as cross bound (low > high) not happened, continue swapping
        while (low <= high) {

            // in this loop, we move the low bound to right until it reaches an element that is
            // smaller than or equal to the pivot
            while (low <= len && array[low] >= pivot) {
                // increment the pointer low as long as the new_array[low] is less than pivot
                low++;
            }

            // Then, we move the high bound to left until it reaches an element that is
            // larger than the pivot and not cross the bound
            while (low <= high && high >= 0 && array[high] < pivot ) {
                // decrement the pointer
                high--;
            }

            // swap the elements and low & high if cross bound does not happen
            // high >= 0 to avoid the situation that high is pointing outside array
            if (low <= high && high > 0) {
                if (high == low)
                    high--;
                swap(array, low, high);
            }
        }

        // swap the pivot and low bound if cross bound happened
        swap(array, p, high);

        // the final position of the pivot is at high
        int final_num = high;

        return final_num;
    }
    // the swap method swap element in index a with element in index b
    private int[] swap(int[] array, int a, int b) {
        int tmp = array[b];
        array[b] = array[a];
        array[a] = tmp;

        return array;
    }
}

