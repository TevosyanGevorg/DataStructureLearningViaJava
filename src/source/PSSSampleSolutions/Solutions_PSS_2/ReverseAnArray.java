
public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 4, 3, 9, 0, 6};
        printArray(arr);

        reverse(arr);

        printArray(arr);
    }
    public static void reverse(int[] arr){
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int[] arr, int low, int high) {
        if(low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            reverse(arr, low + 1, high - 1);
        }
    }

    private static void printArray(int[] data){
        for (int element : data) {
            System.out.print(element + " ");
        }

        System.out.println();
    }
}
