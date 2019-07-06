package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 * 面试题15 二进制中1的个数
 描述：输入一个整数，计算该数二进制中1的个数。
 思路：方法一逐位上移，将1和整数进行与计算；方法二有点奇技淫巧的感觉了，需要想到整数-1后的二进制数特点。在Java里，可以通过Integer.toBinaryString函数查看整数的二进制形式。
 考点：对二进制的理解，和对位运算的掌握。
 */
public class Solution15 {

    public static int numOfOne_a(int num){
        int count=0;
        while(num!=0){
            num=num&(num-1);
            count++;
        }
        return count;

    }

    public static int numOfOne_b(int num){
        int count=0;
        int i=1;
        while(num>=i){
           if((num&i)==i) {
               count++;
           }
            i=i*2;
        }
        return count;

    }

    // 测试
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(10000));
        System.out.println(numOfOne_a(10000));
        System.out.println(numOfOne_b(10000));
    }
}
