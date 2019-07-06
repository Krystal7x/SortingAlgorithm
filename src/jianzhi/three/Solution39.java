package jianzhi.three;

import java.util.Arrays;

/**
 * Created by tt on 2018/9/21.
 */
public class Solution39 {

    public static void main(String[] args) {
       int[] arr =new int[]{1,2,1,2,2};
        System.out.println(postHalf2(arr));
    }

    private static boolean postHalf1(int[] arr) {
        Arrays.sort(arr);
        int middle=arr.length/2;
        int mid= arr[middle];
        int count=0;
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
            if(arr[i]==mid){count++;}
        }
        if(count>middle){
            return true;
        }
        return false;
    }


    private static boolean postHalf2(int[] arr) {
        int count=0;
        int privot=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==privot && count>=0){count++;}
            else if(count==0){ privot=arr[i];count=1;
            }else{
                count--;
            }
        }
        if(count>0){
            return  true;
        }

        return false;
    }
}
