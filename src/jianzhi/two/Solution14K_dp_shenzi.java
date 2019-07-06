package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 */
public class Solution14K_dp_shenzi {
    public static int max(int len){
        if(len<0){ return 0;}
        if(len==1){return 0;}
        if(len==2){return 1;}
        if(len==3){return 2;}
        int[] arr = new int [len+1];
        arr[0]=0;
        arr[1]=1;
        arr[2]=2;
        arr[3]=3;
        for(int i=4;i<len+1;i++){
            for(int j=1;j<=i/2;j++){
                if(arr[j]*arr[i-j]>arr[i]){
                    arr[i]=arr[j]*arr[i-j];
                }
            }
        }
     return arr[len];
    }


    // 贪婪算法，很不容易想到
    //先是要有3还要有2，然后是3要尽可能多，然后2多
    public static int maxProduct_s2(int len) {
        if (len < 2) {return 0;}
        if (len == 2) {return 1;}
        if (len == 3) {return 2;}
        int times3 = len / 3;
        if (len - times3 * 3 == 1)
        {times3--;}
        int times2 = (len - times3 * 3) / 2;
        return (int) (Math.pow(3, times3)) * (int) (Math.pow(2, times2));

    }

    public static void main(String[] args) {
        System.out.println(max(7));
    }

}
