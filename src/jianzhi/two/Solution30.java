package jianzhi.two;

import java.util.Stack;

/**
 * Created by tt on 2018/9/19.
 */
public class Solution30 {

    public static class minStack{
        Stack<Integer> s=    new Stack<Integer>();
        Stack<Integer> min=   new Stack<Integer>();
        public void push(int n){
            s.push(n);
            if(min.isEmpty() || min.peek()>n){
                min.push(n);
            }else{
                min.push(min.peek());
            }

        }
        public int  pop(){
            min.pop();
            return s.pop();
        }
        public int  min(){
            return min.peek();
        }

    }

    public static void main(String[] args) {
        minStack ms = new minStack();
        ms.push(2);
        ms.push(3);
        ms.push(1);
        System.out.println(ms.min());
        System.out.println(ms.pop());
        System.out.println(ms.min());


    }
}


