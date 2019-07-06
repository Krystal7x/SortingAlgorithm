package jianzhi.three;

/**
 * Created by tt on 2018/9/19.
 */
public class Solution45 {

    public static void QuickSort2(int[] arr,int low,int high) {
        if(low<high) {
            int i = low - 1;
            int j = high + 1;
            int middle = arr[(i + j) / 2];
            while (true) {
                while (i < high &&   isSmall(arr[++i],middle) ) {
                }
                while (j > 0 &&  isSmall(middle,arr[--j])) {
                }
                if (i >= j) {
                    break;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            QuickSort2(arr, low, i - 1);
            QuickSort2(arr, j + 1, high);
        }

    }

    //
    public static boolean isSmall(int s1,int s2){
        String str1 = String.valueOf(s1)+String.valueOf(s2);
        String str2 = String.valueOf(s2)+String.valueOf(s1);
        return  str2.compareTo(str1)>0;


    }
    public static void main(String[] args) {
        int arr[] = { 3, 1, 2, 11 };
        QuickSort2(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
