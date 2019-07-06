package jianzhi.three;

/**
 * Created by tt on 2018/9/18.
 */
public class Solution44 {
    public static int digitAtIndex(int num) {
        if(num<10){return num;}
        int n=2;
        num=num-10;
        while(true){
            int numOfN=(int)(Math.pow(10,n-1)*9);
            if(num<numOfN){
                int N = (int)(Math.pow(10,n-1)+num/n);//得到对应哪一位整数
                int index = n-num%n;//从右边开始第几位
                for(int i=1;i<index;i++){
                    n=n/10;
                }
                return num % 10 ;

            }
            n++;
            num = num- numOfN;

        }
    }

    public static void main(String[] args) {
        System.out.println(digitAtIndex(1001));
    }
}
