package jianzhi.three;

/**
 * Created by tt on 2018/9/20.
 *  题目：
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc, 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * ps：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Solution38_StringPermutation {


    public static void Permutation(char[] arr,int index){
        if(index==arr.length){
            System.out.println(arr);
        }else{
            for(int i = index; i < arr.length; ++i) {
                swap(arr, i, index);
                Permutation(arr, index + 1);
                swap(arr, i, index);
            }
        }
    }
    private static void swap(char[] chars, int indexA, int indexB) {
        char c = chars[indexA];
        chars[indexA] = chars[indexB];
        chars[indexB] = c;
    }

    public static void main(String[] args) {
       /* String str="aabc";
        char[] arr=str.toCharArray();
        Permutation(arr,0);*/

       stringCombination("abc");
    }


    /**
     * 题目：
     * 输入一个字符串，求字符串中字符的所有组合
     * 例如输入字符串"abc"，则它们的组合有a, b, c, ab, ac, bc, abc
     * 当交换字符串中的两个字符时，虽然能得到两个不同的排列，但却是同一个组合。
     * 比如 ab 和 ba 是不同的排列，但只算一个组合。
     *如果组合里包含第一个字符，则下一步在剩余的n-1个字符里选择m-1个字符；
     如果组合里不包含第一个字符，则下一步在剩余的n-1个字符里选择m个字符。
     * @author peige
     */

    public static void stringCombination(String str) {
        if(str == null || str.trim().length() == 0){ return ;}
        char chars[] = str.toCharArray();
        for(int i = 1; i <= str.length(); ++i) {
            stringCombination(chars, 0,i,"");
        }
    }

    private static void stringCombination(char[] chars,int index, int length,String s) {
        if(length == 0) {System.out.println(s);return;}
        if(chars.length - index < length) {return; }
        // 选择第一个，从剩下的中选择length-1个
        stringCombination(chars, index+1,length - 1,s.concat(String.valueOf(chars[index])));
        // 不选择第一个，从剩下的中选择length个
        stringCombination(chars, index+1,length,s);
    }


}
