
public class ModifiedSelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 4, 3, 9, -1};
        printArray(arr);

        System.out.println();
        selectionSort(arr);

        printArray(arr);
    }

    public static void selectionSort(int[ ] data) {
        int n = data.length;
        int midIdx = (data.length % 2 == 0) ? n / 2 : n / 2 + 1;

        for (int k = 0; k < n - 1; ++k) {
            int pos = (k < n / 2) ? k + midIdx : k - n / 2;
            int min = pos;

            for (int j = k + 1; j < n; j++)
            {
                int curPos = (j < n / 2) ? j + midIdx : j - n / 2;

                if (data[curPos] < data[min])
                    min = curPos;
            }

            int temp = data[pos];
            data[pos] = data[min];
            data[min] = temp;
        }
    }

    private static void printArray(int[] data){
        for (int element : data) {
            System.out.print(element + " ");
        }
    }
}
