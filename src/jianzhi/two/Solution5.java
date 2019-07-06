package jianzhi.two;

/**
 * Created by tt on 2018/9/17.
 * 描述：将字符串中的每个空格替换成%20。如输入"we are fine"，输出"we%20are%20fine"。
 思路：原题考察了C++中指针的操作。Java里数组不可变，因此本题变得没有难度了。利用String对象的.charAt函数遍历每个字符，并使用StringBuilder构建新的字符串。
 考点：对字符串的处理。
 */
public class Solution5 {
    public static String  replaceBlank(String str){
        StringBuilder result = new StringBuilder();
        char bank= ' ';
        char[] arr=str.toCharArray();
        for(int i= 0;i<arr.length;i++){
            if(arr[i] == bank){
               result.append("%20");
            }
            else if(arr[i] != bank) {
                result.append(arr[i]);
            }
        }
        return result.toString();
    }
    // 测试
    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(replaceBlank(str));
    }
}
