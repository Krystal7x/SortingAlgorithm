package jianzhi.three;

/**
 * Created by tt on 2018/9/19.
 */
public class Solution64 {

    public static int sum1(int n) {
        int result=0;
        boolean a= (n>0) && ((result=n+sum1(n-1))>0);
        return result;
    }
    // 测试
    public static void main(String[] args) {
        System.out.println(sum1(10));
    }
}
