package PSSSampleSolutions.solutions_PSS_5;

import PSSSampleSolutions.solutions_PSS_5.arrayList.ArrayList;

public class Problem6 {

    public static void main(String[] args) {

    }


    public static void sortBasedOnK(ArrayList<Integer> list, int k) {
        int first = 0;
        int last = list.size() - 1;

        while (first <= last) {
            if (list.get(first) <= k) first++;
            else if (list.get(last) >= k) last--;
            else {
                int temp = list.get(first);
                list.set(first, list.get(last));
                list.set(last, temp);
                first++;
                last--;
            }
        }
    }


}
