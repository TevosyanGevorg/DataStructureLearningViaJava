
public class RecursiveSelectionSort {

    public static void main(String[] args) {
        int[] data = new int[]{8, 4, 3, 9, 0, -1, 6};

        printArray(data);

        System.out.println();
        selectionSort(data);

        printArray(data);

    }

    public static void selectionSort(int[] data){
        selectionSort(data, 0, 1);
    }

    private static void selectionSort(int[] data, int k, int j) {
        if(k >= data.length)
            return;

        if(j < data.length)
        {
            if (data[j] < data[min]) // a new minimum found
                min = j;

            selectionSort(data, k, j + 1);
        }
        else {
            int temp = data[k];
            data[k] = data[min];
            data[min] = temp;

            min = k + 1;
            selectionSort(data, k + 1,k + 2 );
        }
    }
    static private int min = 0;

    private static void printArray(int[] data){
        for (int element : data) {
            System.out.print(element + " ");
        }
    }
}
