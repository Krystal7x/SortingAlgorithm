package jianzhi.three;

/**
 * Created by tt on 2018/9/20.
 */
public class Solution66 {
    public static int[] multiply(int[] A) {
        if(A == null)
        { return null;}
        if(A.length == 0)
        {return new int[0];}
        // 下半部分的三角形
        int[] result = new int[A.length];
        result[0] = 1;
        for(int i = 1; i < A.length; ++i) {
            result[i] = result[i-1] * A[i-1];
        }
        // 上半部分三角形
        int tmp = 1;
        for(int i = A.length - 2; i >= 0; --i) {
            tmp *= A[i + 1];
            result[i] *= tmp;
        }
        return result;
    }
}
