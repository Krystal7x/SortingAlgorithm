package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 * 面试题10 斐波那契数列

 描述：计算斐波那契数列的第n项。
 思路：使用循环从下往上计算数列。
 考点：考察对递归和循环的选择。使用递归的代码通常比循环简洁，但使用递归时要注意一下几点：
 1、函数调用的时间和空间消耗；2、递归中的重复计算；3、最严重的栈溢出。根据斐波那契数列递归形式定义很容易直接将代码写成递归，而这种方式有大量重复计算，效率很低。
 */
public class Solution10 {
    //递归
    public static int f(int i){
        if(i==0){return 0;}
        if(i==1){return 1;}
        return f(i-1)+f(i-2);

    }
    //循环实现
    public static int f2(int n){
        if(n==0){return 0;}
        if(n==1){return 1;}
        int f0=0;
        int f1=1;
        int temp=0;
        for(int i=2;i<=n;i++){
            temp=f0+f1;
            f0=f1;
            f1=temp;
        }
        return temp;

    }
    public static void main(String[] args) {
        System.out.println(f(4));
        System.out.println(f2(4));
        System.out.println(f2(7));
    }
}
