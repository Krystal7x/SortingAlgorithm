package jianzhi.two;

import java.util.Arrays;

/**
 * Created by tt on 2018/9/18.
 * 面试题21 调整数组顺序使奇数位于偶数前面
 描述：操作输入的整数数组，实现所有奇数位于数组的前部分，偶数位于数组的后部分。
 思路：比较容易想到使用两个变量分别指向数组的首段、尾端，向中间聚拢，完成数组顺序调整。
 考点：对数组的操作；对程序扩展性的考虑。
 */
public class Solution21 {
    public static void reorderOddEven(int[] arr){
        int i=-1 ;
        int j=arr.length;
        while(true){
            while(!isOdd(arr[++i])){}
            while(isOdd(arr[--j])){}
            if (i >= j) {break;}
            int temp= arr[i];
             arr[i]=arr[j];
            arr[j]=temp;

        }
    }
    // 单独定义一个函数，提高扩展性
    private static boolean isOdd(int x) {
        return (x & 1) == 1;
    }

    // 测试
    public static void main(String[] args) {
        int[] arr = { 0, 1, 3, 5, 4, 9 };
        reorderOddEven(arr);
        System.out.println(Arrays.toString(arr));
    }
}
