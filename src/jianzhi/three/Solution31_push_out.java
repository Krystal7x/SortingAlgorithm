package jianzhi.three;

import java.util.Stack;

/**
 * Created by tt on 2018/9/19.
 */
public class Solution31_push_out {
    public static boolean isSteak(int[] push,int[] out){
        if(push == null || out == null || push.length != out.length){return false;}
        Stack<Integer> s= new Stack<Integer>();
        int outindex=0;
        for(int i=0;i<push.length;i++){
            s.push(push[i]);
            while(!s.isEmpty()&&s.peek()==out[outindex]){
                s.pop();
                outindex++;
            }
        }
        if(s.isEmpty()){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr1=new int[]{1,2,3,4,5};
        int[] arr2=new int[]{1,2,3,5,4};
        System.out.println(isSteak(arr1,arr2));
    }


}
