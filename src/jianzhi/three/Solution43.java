package jianzhi.three;

/**
 * Created by tt on 2018/9/18.
 * 1~n整数中出现1的个数
 */
public class Solution43 {

    public static int getcount(int num) {
        int count=0;
        while(num!=0){
            if(num%10==1){count++;}
            num=num/10;
        }
        return count;
    }
    //1
    public static void count(int n) {
        int count=0;
        for(int i=1;i<n;i++){
            count=count+getcount(i);
        }
        System.out.println(count);
    }

    //2


    public static void main(String[] args) {
        count(11);
    }
}
