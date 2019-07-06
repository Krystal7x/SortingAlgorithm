package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 * 描述：输入数字n，按顺序打印出1到n的十进制数。
 思路：这是一个大数问题，当n巨大时，就要用数组来记录了，方法用递归
 */
public class Solution17 {
    // 数字排列方法
    public static void maxOfND(int n) {
        char[] num =new char[10];
        if(n<0){return;}
        int index=0;
        for(int i=0;i<10;i++){
            num[index]=(char)(i+'0');
            digui(num, n, index+1);
        }

    }
    public static void digui(char[] num,int n,int index) {
        if(index+1>=n){printnum( num);return;}
        for(int i=0;i<10;i++){
            num[index]=(char)(i+'0');
            digui(num, n, index+1);
        }

    }
    public static void printnum(char[] num) {
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]);
        }
        System.out.println();
    }




    public static void maxOfND2(int n) {
        if(n<0){return;}
        char[] str= new char[n];
        for(int i=0;i<str.length;i++){str[i]='0';}
        while(true) {
            //永远是最后一位+1
            if (lastADD(str)) {break;}
                str[n - 1] = (char) (str[n - 1] + 1);
                for (int i = str.length - 1; i >= 1; i--) {
                    //处理10进位
                    int num = str[i] - '0';
                    if (num == 10) {
                        str[i] = '0';
                        str[i - 1] = (char) (str[i - 1] + 1);
                    } else {
                        break;
                    }
                }
                printnum(str);
            }

    }

    public static boolean lastADD(char[] arr){
        for(int i=0 ;i<arr.length;i++){
            if(arr[i]!='9'){
                return false;
            }
        }
        return  true;
    }

    // 测试
    public static void main(String[] args) {
        //maxOfND(5);

        maxOfND2(5);




       // System.out.println( (char) (1 + '0'));
    }
}