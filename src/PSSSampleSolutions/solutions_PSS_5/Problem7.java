package PSSSampleSolutions.solutions_PSS_5;

import PSSSampleSolutions.solutions_PSS_5.arrayList.ArrayList;

import java.util.Objects;

public class Problem7 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(0, "1");
        arrayList.add(1, "+");
        arrayList.add(2, "2");
        arrayList.add(3, "5");
        arrayList.add(4, "4");
        arrayList.add(5, "+");
        arrayList.add(6, "*");
        arrayList.add(7, "3");
        arrayList.add(8, "12");
        arrayList.add(9, "-");
        arrayList.add(10, "/");
        arrayList.add(11, "42");
        arrayList.add(12, "+");

        problem4(arrayList);


        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    public static void problem4(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (Objects.equals(arrayList.get(i), "+")) {
                if (i == 1 && !checkOperation(arrayList.get(0))) {
                    arrayList.set(0, String.valueOf(Integer.parseInt(arrayList.get(0)) + Integer.parseInt(arrayList.get(0))));
                    arrayList.remove(i);
                    i--;
                } else if (i > 2 && (checkOperation(arrayList.get(i - 1)) || checkOperation(arrayList.get(i - 2)))) {
                    if (checkOperation(arrayList.get(i - 1)))
                        arrayList.set(i - 2, String.valueOf(Integer.parseInt(arrayList.get(i - 2)) * 2));
                    else
                        arrayList.set(i - 1, String.valueOf(Integer.parseInt(arrayList.get(i - 1)) + Integer.parseInt(arrayList.get(i - 1))));
                    arrayList.remove(i);
                    i--;
                } else if (i > 2 && (!checkOperation(arrayList.get(i - 1)) && !checkOperation(arrayList.get(i - 2)))) {
                    arrayList.set(i - 2, String.valueOf(Integer.parseInt(arrayList.get(i - 2)) + Integer.parseInt(arrayList.get(i - 1))));
                    arrayList.remove(i - 1);
                    arrayList.remove(i - 1);
                    i -= 2;
                }
            } else if (Objects.equals(arrayList.get(i), "-")) {
                if (i == 1 && !checkOperation(arrayList.get(0))) {
                    arrayList.set(0, String.valueOf(Integer.parseInt(arrayList.get(0)) - Integer.parseInt(arrayList.get(0))));
                    arrayList.remove(i);
                    i--;
                } else if (i > 2 && (checkOperation(arrayList.get(i - 1)) || checkOperation(arrayList.get(i - 2)))) {
                    if (checkOperation(arrayList.get(i - 1)))
                        arrayList.set(i - 2, String.valueOf(Integer.parseInt(arrayList.get(i - 2)) - Integer.parseInt(arrayList.get(i - 2))));
                    else
                        arrayList.set(i - 1, String.valueOf(Integer.parseInt(arrayList.get(i - 1)) - Integer.parseInt(arrayList.get(i - 1))));
                    arrayList.remove(i);
                    i--;
                } else if (i > 2 && (!checkOperation(arrayList.get(i - 1)) && !checkOperation(arrayList.get(i - 2)))) {
                    arrayList.set(i - 2, String.valueOf(Integer.parseInt(arrayList.get(i - 2)) - Integer.parseInt(arrayList.get(i - 1))));
                    arrayList.remove(i - 1);
                    arrayList.remove(i - 1);
                    i -= 2;
                }

            } else if (Objects.equals(arrayList.get(i), "/")) {
                if (i == 1 && !checkOperation(arrayList.get(0))) {
                    arrayList.set(0, "1");
                    arrayList.remove(i);
                    i--;
                } else if (i > 2 && (checkOperation(arrayList.get(i - 1)) || checkOperation(arrayList.get(i - 2)))) {
                    if (checkOperation(arrayList.get(i - 1)))
                        arrayList.set(i - 2, "1");
                    else
                        arrayList.set(i - 1, "1");
                    arrayList.remove(i);
                    i--;
                } else if (i > 2 && (!checkOperation(arrayList.get(i - 1)) && !checkOperation(arrayList.get(i - 2)))) {
                    arrayList.set(i - 2, String.valueOf(Integer.parseInt(arrayList.get(i - 2)) / Integer.parseInt(arrayList.get(i - 1))));
                    arrayList.remove(i - 1);
                    arrayList.remove(i - 1);
                    i -= 2;
                }

            } else if (Objects.equals(arrayList.get(i), "*")) {
                if (i == 1 && !checkOperation(arrayList.get(0))) {
                    arrayList.set(0, String.valueOf(Integer.parseInt(arrayList.get(0)) * Integer.parseInt(arrayList.get(0))));
                    arrayList.remove(i);
                    i--;
                } else if (i > 2 && (checkOperation(arrayList.get(i - 1)) || checkOperation(arrayList.get(i - 2)))) {
                    if (checkOperation(arrayList.get(i - 1)))
                        arrayList.set(i - 2, String.valueOf(Integer.parseInt(arrayList.get(i - 2)) * Integer.parseInt(arrayList.get(i - 2))));
                    else
                        arrayList.set(i - 1, String.valueOf(Integer.parseInt(arrayList.get(i - 1)) * Integer.parseInt(arrayList.get(i - 1))));
                    arrayList.remove(i);
                    i--;
                } else if (i > 2 && (!checkOperation(arrayList.get(i - 1)) && !checkOperation(arrayList.get(i - 2)))) {
                    arrayList.set(i - 2, String.valueOf(Integer.parseInt(arrayList.get(i - 2)) * Integer.parseInt(arrayList.get(i - 1))));
                    arrayList.remove(i - 1);
                    arrayList.remove(i - 1);
                    i -= 2;
                }
            }
        }
    }

    private static boolean checkOperation(String s) {
        return Objects.equals(s, "+") || Objects.equals(s, "-") || Objects.equals(s, "*") || Objects.equals(s, "/");
    }
}
