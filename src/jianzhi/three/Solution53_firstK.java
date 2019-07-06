package jianzhi.three;

/**
 * Created by tt on 2018/10/9.
 */
public class Solution53_firstK {
    public int getFirstK(int[] array,int start,int end ,int k){
        if(start>end){return -1;}
        int middle =(start+end)/2;
        if(array[middle]>k){return getFirstK(array, start, middle-1 , k);}
        else if(array[middle]<k){return getFirstK(array,middle+1,end , k);}
        else if(middle>0&&array[middle-1]==k){return getFirstK(array, start, middle-1 , k);}
        return middle;
    }


    public int getLastK(int[] array,int start,int end ,int k){
        if(start>end){return -1;}
        int middle =(start+end)/2;
        if(array[middle]>k){return getFirstK(array, start, middle-1 , k);}
        else if(array[middle]<k){return getFirstK(array,middle+1,end , k);}
        else if(middle<end&&array[middle+1]==k){return getFirstK(array,middle+1,end , k);}
        return middle;
    }

}
