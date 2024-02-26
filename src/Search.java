public class Search {
    public static boolean binary(int[] data, int target, int low, int high) {
        if (low > high) return false;
        else {
            int mid = (low + high) / 2;
            if (target == data[mid])
                return true;
            else if (target < data[mid])
                // interval empty; no match // found a match
                return binary(data, target, low, mid - 1); // recur left of the middle else
            return binary(data, target, mid + 1, high); // recur right of the middle }

        }
    }
}
