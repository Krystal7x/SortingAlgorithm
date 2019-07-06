package jianzhi.two;

/**
 * Created by tt on 2018/9/20.
 */
public class Solution19K_digui_regx {
    private static boolean match(char[] inStr, char[] inPattern)
    {
        if (inStr == null || inPattern == null) {return false;}
        char[] str = inStr;
        char[] pattern = inPattern;
        return matchRegular(str,0,pattern, 0);
    }

    private static boolean matchRegular( char[] str,int strIndex,char[] pattern, int patternIndex)
    {
        //字符和模式全部匹配
        if (str.length == strIndex && pattern.length == patternIndex){return true;}
        if ((str.length != strIndex && pattern.length == patternIndex)){return false;}
        //模式的下一个字符是‘*’
        if (patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*'){
            //当前字符匹配
            if (strIndex < str.length && (pattern[patternIndex] == str[strIndex]
                    || pattern[patternIndex] == '.')){
                return matchRegular(str,strIndex + 1,pattern, patternIndex + 2)  //字符串和模式都移动
                        || matchRegular(str,strIndex + 1,pattern, patternIndex)  //字符串移动，模式不动
                        || matchRegular(str,strIndex,pattern, patternIndex + 2);  //字符串不动，模式移动
            } else{
                return matchRegular(str,strIndex, pattern,patternIndex + 2); //字符串不动，模式移动
            }
        }
        //当前字符和模式的字符匹配
        if (strIndex < str.length && (pattern[patternIndex] == str[strIndex]|| pattern[patternIndex] == '.')){
            return matchRegular(str,strIndex + 1, pattern,patternIndex + 1);  //模式和字符串都移动
        }
        //当前字符不匹配
        return false;
    }
    public static void main(String[] args) {

    }
}
