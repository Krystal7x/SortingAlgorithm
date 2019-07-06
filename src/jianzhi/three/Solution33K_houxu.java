package jianzhi.three;

/**
 * Created by tt on 2018/9/20.
 */
public class Solution33K_houxu {

    public static boolean isHouxu(int[] arr,int start,int end){
        if(end - start <= 1){return true;}
        int root=arr[end];
        int i=start;
        for( i=start;i<end;i++){
            if(arr[i]>=root){break;}
        }
        int index=i;
        for(;i<end;i++){
            if(arr[i]<root){return false;}
        }
        return isHouxu(arr,start,index-1)&& isHouxu(arr,index,end-1);
    }

    private static boolean VerifySequenceOfBST(int[] sequence, int start, int end) {
        if(end - start <= 1){return true;}
        int root = sequence[end];
        int preIndex = start;
        int lastIndex = end - 1;

        while(preIndex <= lastIndex) {
            if(sequence[preIndex] > root) {break;}
            ++preIndex;
        }
        while(lastIndex >= start) {if(sequence[lastIndex] < root) {break;}
            --lastIndex;
        }

        if(preIndex == lastIndex + 1){
            return VerifySequenceOfBST(sequence, start, lastIndex) &&VerifySequenceOfBST(sequence, preIndex, end - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,3,2,5,7,6,4};
        System.out.println(isHouxu(arr,0,6));

        int[] arr1=new int[]{1,3,2,9,0,6,4};
        System.out.println(isHouxu(arr1,0,6));
    }
}
