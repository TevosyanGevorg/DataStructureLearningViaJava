
public class RecursiveBubleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 4, 3, 9, -1, 0};
        printArray(arr);

        System.out.println();
        bubbleSort(arr);

        printArray(arr);
    }

    /** Bubble-sort of an array of integers to nondecreasing order */
    public static void bubbleSort(int[] data) {
        bubbleSort(data, 0, 0, false);
    }

    /**
     * denote n = data.length
     *
     * running time consumption: O(n^2), because
     * from each k node it will go deeper n - k - 1 times, so
     * n-1, n-2, n-3,..., 2, 1 and in this method  we have only
     * constant work doing lines and recursive calls => (n-1) * n/2 => O(n^2).
     *
     * memory consumption: O(n), because if we draw the recursive relation tree, then its max height will be n
     * and there is no any other memory allocation in any call.
     */
    private static void bubbleSort(int[] data, int k, int j, boolean swapped) {
        if(k >= data.length)
            return;
        else if (j >= data.length - k - 1) {
            if(!swapped)
                return;

            bubbleSort(data, k + 1, 0, false);
        }
        else if (data[j] > data[j + 1]) {
            int temp = data[j];
            data[j] = data[j + 1];
            data[j + 1] = temp;

            swapped = true;

            bubbleSort(data, k, j + 1, swapped);
        }
        else
            bubbleSort(data, k, j + 1, swapped);

    }

    private static void printArray(int[] data){
        for (int element : data) {
            System.out.print(element + " ");
        }
    }
}
