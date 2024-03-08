package HomeWorks.HomeworkAssignment_1;

import java.util.Scanner;

public class Magnets {
    private static boolean[][] magnets ;
    private static int N=0;
    private static int K=0;
    public static void initializeMagnets(Scanner scanner){

        System.out.print("please insert magnets Colum count. N= ");
        N= scanner.nextInt();
        System.out.print("please insert magnets Row count. K= ");
        K= scanner.nextInt();
        magnets=new boolean[K][N];

        for (int i=0;i<N;i++)
        {
            System.out.print("please inset Count(0>=count<="+K+") of magnets in Column N("+i+"): ");
            int countOfMagnets=scanner.nextInt();
            for (int j=K-1;j>=0;j--)
            {
                if (countOfMagnets!=0)
                {
                    magnets[j][i]=true;
                    --countOfMagnets;
                }
                else
                    magnets[j][i]=false;
            }
        }
    }
    public static void holdingMagnetAtTheLeftSide(){
        for (boolean[] row : magnets)
        {
            for (int i = row.length-1; i >=0 ; i--) {
                if (row[i] == false) {
                    for (int j = i-1; j >=0 ; j--) {
                        if (row[j]==true) {
                            row[j]=false;
                            row[i]=true;
                        }
                    }
                }

            }
        }
    }

    public  static void showMagnets(){
        for (boolean[] row : magnets)
        {
            for (boolean i : row)
            {
                System.out.print(i?"[]":" " + " ");
            }
            System.out.println();
        }

    }
}
