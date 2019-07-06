package jianzhi.two;

import java.util.Stack;

/**
 * Created by tt on 2018/9/17.
 * 从头到尾打印链表
 */
public class Solution6 {
    //递归实现
    public static void printListReverse_rec(ListNode n1){
        if(n1==null){return;}
        else{
            printListReverse_rec(n1.next);
            System.out.println(n1.value);
        }
    }

    //stack实现
    public static void printListReverse(ListNode n1){
        Stack<ListNode> s= new Stack<ListNode> ();
        while(n1!=null){s.push(n1);n1=n1.next;}
        while(s.size()>0){System.out.println(s.pop().value);}
    }
    //测试
    public static void main(String[] args) {
        ListNode ln1 = new ListNode();
        ListNode ln2 = new ListNode();
        ListNode ln3 = new ListNode();
        ln1.next = ln2;
        ln2.next = ln3;
        ln1.value = 1;
        ln2.value = 2;
        ln3.value = 3;
        printListReverse_rec(ln1);
        printListReverse(ln1);
    }

}
