package jianzhi.two;

/**
 * Created by tt on 2018/9/18.
 * 面试题24 反转链表

 描述：输入链表的头结点，反转链表并输出反转后链表的头节点。
 思路：要定义pre和next变量存储断开前后的节点。
 考点：对链表的理解。
 */
public class Solution24_ReverseList {

    public static jianzhi.three.ListNode reverseList(jianzhi.three.ListNode root){
        if(root==null){return  null;}
        jianzhi.three.ListNode pre=null;
        jianzhi.three.ListNode cur=root;
        jianzhi.three.ListNode next = null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;

        }
        return pre;
    }


    // 测试
    public static void main(String[] args) {
        jianzhi.three.ListNode[] ln = new jianzhi.three.ListNode[6]; // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        for (int i = 0; i < ln.length; i++) {
            ln[i] = new jianzhi.three.ListNode();
            ln[i].value = i + 1;
            if (i > 0){ ln[i - 1].next = ln[i];}
        }
        ln[0].printOut();
        reverseList(ln[0]);
        System.out.println("=========反转前后========");
        ln[5].printOut();
    }
}
