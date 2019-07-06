package jianzhi.three;

import java.util.HashMap;

/**
 * Created by tt on 2018/9/19.
 * 面试题50 第一个只出现一次的字符

 描述：字符串中第一个只出现一次的字符。
 思路：利用字符的ASCII作为数组的索引，实现一个简单的哈希表。先遍历字符串计数，再遍历数组。
 考点：对字符串以及哈希表的理解。
 */
public class Solution50_repeatStr {



    public static String  firstRepeatchar(String str){
        if(str.length()<=0){ return  null;}
        HashMap<Character,Integer> h = new HashMap<Character,Integer>(16);
        for(int i=0;i<str.length();i++){
            Character c =  str.charAt(i);
            if(h.get(c)==null){h.put(c,1);}
            else{
                int count=h.get(c)+1;
                h.put(c,count);
            }
        }
        for(int i=0;i<str.length();i++) {
          if((h.get(str.charAt(i))==1)){
              return  String.valueOf(str.charAt(i));
          }
        }
        return  null;
    }


    public static String  delRepeatchar(String str){
        if(str.length()<=0){ return  null;}
        StringBuilder sb =new StringBuilder();
        int arr[] =new int[26];
        for(int i=0;i<str.length();i++){
            if(arr[(int)(str.charAt(i)-'a')]==0){
                arr[(int)(str.charAt(i)-'a')]++;
                sb.append(str.charAt(i));
            }
        }
        return  sb.toString();
    }



    public static String  delCharInStr2(String str1,String str2){
        int[] arr =new int[26];
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<str2.length();i++){
            if(arr[(int)(str2.charAt(i)-'a')]==0){
                arr[(int)(str2.charAt(i)-'a')]++;
            }
        }

        for(int i=0;i<str1.length();i++){
            if(arr[(int)(str1.charAt(i)-'a')]==0){
                sb.append(str1.charAt(i));
            }
        }
        return  sb.toString();
    }





    public static boolean  isAnagram(String str1,String str2){
        if(str1.length()!=str2.length()){ return  false;}
        int[] arr =new int[26];

        for(int i=0;i<str1.length();i++){
                arr[(int)(str1.charAt(i)-'a')]++;
        }
        for(int i=0;i<str2.length();i++){
                arr[(int)(str2.charAt(i)-'a')]--;
        }
        for(int i=0;i<arr.length;i++){
           if(arr[i]!=0){ return  false;}
        }
        return  true;
    }

    // 测试
    public static void main(String[] args) {
        //第一个不重复
        System.out.println(firstRepeatchar("abaccdeff"));
        //去重
        System.out.println(delRepeatchar("abaccdeff"));
        //相关题目：从第一个字符串中删除在第二个字符串中出现过的所有字符
        System.out.println(delCharInStr2("wearestudent", "aeiou"));
        // 相关题目：判断是否是变位词
       System.out.println(isAnagram("silent", "listen"));
    }

}
