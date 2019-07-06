package jianzhi.three;

/**
 * Created by tt on 2018/9/18.
 */
public class Solution42 {
    public static int maxSub(int[] arr) {
        int max=0;
        int cur=0;
        for(int i=0;i<arr.length;i++){
            cur=cur+arr[i];
            if(cur>max){max=cur;}
            if(cur<0){max=0;}
        }
        return max;

    }

    // 测试
    public static void main(String[] args) {
        int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
        System.out.println(maxSub(arr));
    }
}
