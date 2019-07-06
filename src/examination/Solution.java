package examination;


import java.util.Scanner;

public class Solution {
    public static  boolean Judge(String s) {
        if (s.isEmpty()) {return true; }
        int head = 0, tail = s.length() - 1;
        while(head <= tail) {
            if(s.charAt(tail) != s.charAt(head)) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
    public static void main(String[] args) {
        int max = -1;
        Scanner in = new Scanner(System.in);
        String res = in.nextLine();
        for(int i = 0 ; i < res.length(); i ++){
            for(int j = i; j < res.length(); j ++){
                String temp =  res.substring(i, j+1);
                if(Judge(temp)){
                    if(temp.length() >  max ){
                        max = temp.length();
                    }
                }
            }
        }
        System.out.println(max);

    }
}