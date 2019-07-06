package jianzhi.three;

/**
 * Created by tt on 2018/10/9.
 */
public class Solution56_repeatMN {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2){return;}
        int n = 0;
        for(int i = 0; i < array.length; ++i)
            n ^= array[i];
        int firstBitIs1 = findFirstBitIs1(n);
        int N = 1 << firstBitIs1;
        num1[0] = 0;
        num2[0] = 0;
        for(int i = 0; i < array.length; ++i) {
            if((array[i] & N) != 0){ num1[0] ^= array[i];}
            else{num2[0] ^= array[i];}
        }
    }

    private int findFirstBitIs1(int n) {
        if(n == 0){return 0;}
        for(int i = 0; i < 32; ++i, n >>= 1) {
            if((n & 1) == 1){return i;}
        }
        return 0;
    }
}
