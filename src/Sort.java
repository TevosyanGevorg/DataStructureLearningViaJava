public class Sort {
    public static void SelectionSort(){
        int[] intArr={5,2,0,3,8,9,6,7};
        int temp;
        for (int i=0; i<intArr.length; i++){
            temp=intArr[i];
            for (int k=1; k<intArr.length; k++)
            {
                if(intArr[i]>intArr[k]){
                    intArr[i]=intArr[k];
                    intArr[k]=temp;
                }
            }
        }
    }
}
