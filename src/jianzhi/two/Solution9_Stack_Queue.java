package jianzhi.two;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by tt on 2018/9/17.
 * 用两个栈实现队列
 */
public class Solution9_Stack_Queue {
    //用两个栈实现队列


    public Stack<Integer> stack1=new Stack<Integer>();
    //弹出队列
    public Stack stack2=new Stack();

    public void push(Integer i){
        stack1.push(i);
    }
    public Integer pop(){
        if(stack2.size()!=0){
            return (Integer) stack2.pop();
        }
        else{
            while(stack1.size()!=0){
                stack2.push(stack1.pop());
            }
            return (Integer)stack2.pop();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //两个队列形成一个栈
    public Queue<Integer> q1=new LinkedList<Integer>();
    public Queue<Integer> q2=new LinkedList<Integer>();

    public void add(int n){
        if(!q1.isEmpty()){q1.add(n);}
        else{q2.add(n);}
    }

    public int poll(){
        while(!q1.isEmpty()&&q1.size()!=1){
            q2.add(q1.poll());
        }
        if(q1.size()==1){return q1.poll();}

        while(!q2.isEmpty()&&q2.size()!=1){
            q1.add(q2.poll());
        }
        if(q2.size()==1){return q2.poll();}

        return -1;
    }

        // 测试
        public static void main(String[] args) {
            Solution9_Stack_Queue sq= new Solution9_Stack_Queue();
            sq.push(1);  sq.push(2);  sq.push(3);
            System.out.println(sq.pop());
            System.out.println(sq.pop());
            sq.push(4);
            System.out.println(sq.pop());
            System.out.println(sq.pop());

            System.out.println();
            System.out.println();

            Solution9_Stack_Queue sq2= new Solution9_Stack_Queue();
            sq2.add(1);  sq2.add(2);  sq2.add(3);
            System.out.println(sq2.poll());
            System.out.println(sq2.poll());
            sq2.add(4);
            System.out.println(sq2.poll());
            System.out.println(sq2.poll());



        }
}
