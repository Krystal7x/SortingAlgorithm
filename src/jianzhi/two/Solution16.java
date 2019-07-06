package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 * 描述：构造求数值的整数幂函数。
 思路：根据整数幂求解的特点，构造高效求解的函数；考虑幂为负整数的情形，以及避免溢出的处理；使用位运算进行除2和判断奇偶。像这种基本的数学函数，竭力提高运算性能总是有必要的。
 考点：对幂运算的掌握。
 */
public class Solution16 {
    //递归实现
    public static double myPow(double a,int n){
        if(n==0){return 1;}
        if(n==1){return a;}
        boolean sign=false;
        if(n<0){n=-n;sign=true;}
        double result=myPow(a,n/2);
        result=result*result;
        if((n&1)==1){result=result*a;}

        if(sign){result=1/result;}
        return result;
    }
    // 测试
    public static void main(String[] args) {
        int a = -2147483648;
        System.out.println(myPow(1.0, a));
        System.out.println(myPow(2.0, -1));
        System.out.println(myPow(2.0, 4));
        System.out.println(myPow(2.0, 3));

    }
}
