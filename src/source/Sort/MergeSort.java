package source.Sort;

public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;  // Base case: already sorted or empty array
        }

        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        // Copy elements to the left and right arrays
        System.arraycopy(array, 0, leftArray, 0, mid);
        System.arraycopy(array, mid, rightArray, 0, array.length - mid);

        // Recursively sort the left and right arrays
        mergeSort(leftArray);
        mergeSort(rightArray);

        // Merge the sorted arrays
        merge(array, leftArray, rightArray);
    }

    private static void merge(int[] result, int[] leftArray, int[] rightArray) {
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        // Compare elements from left and right arrays and merge them into the result array
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                result[resultIndex++] = leftArray[leftIndex++];
            } else {
                result[resultIndex++] = rightArray[rightIndex++];
            }
        }

        // Copy remaining elements from left array
        while (leftIndex < leftArray.length) {
            result[resultIndex++] = leftArray[leftIndex++];
        }

        // Copy remaining elements from right array
        while (rightIndex < rightArray.length) {
            result[resultIndex++] = rightArray[rightIndex++];
        }
    }

}

