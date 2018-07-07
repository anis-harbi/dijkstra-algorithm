
public class Problem1{

   
    // merge a[lo..mid] with a[mid+1..hi] using x[lo..hi]
    private static void merge(Integer[] inputArray, Integer[] x, int lo, int mid, int hi) {

        // copy to x[]
        for (int k = lo; k <= hi; k++) {
            x[k] = inputArray[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              inputArray[k] = x[j++]; 
            else if (j > hi)               inputArray[k] = x[i++];
            else if (x[j] < x[i]) inputArray[k] = x[j++];
            else                           inputArray[k] = x[i++];
        }

    }

    /**
     * Rearranges the array in ascending order
     */
    public static void sort(Integer[] inputArray) {
        int n = inputArray.length;
        Integer[] x = new Integer[n];
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n-len; lo += len+len) {
                int mid  = lo+len-1;
                int hi = Math.min(lo+len+len-1, n-1);
                merge(inputArray, x, lo, mid, hi);
            }
        }
        assert isSorted(inputArray);
    }



    private static boolean isSorted(Integer[] inputArray) {
        for (int i = 1; i < inputArray.length; i++)
            if (inputArray[i] < inputArray[i-1]) return false;
        return true;
    }


    private static void show(Integer[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i]);
        }
    }

    // main method has array hard coded and print array after mergesort is applied
    public static void main(String[] args) {
        Integer[] inputArray = {1,6,4,3,78,65,45,88,23,12};
        Problem1.sort(inputArray);
        show(inputArray);
    }
}
