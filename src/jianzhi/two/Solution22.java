package jianzhi.two;

/**
 * Created by tt on 2018/9/18.
 * 描述：输入一个链表，输出链表中倒数第k个节点。
 思路：无法判断链表大小是主要难点，因此额外定义一个变量，当链表大小大于等于k时进行跟踪。
 考点：对鲁棒性的考虑；小心处理程序，可避免原文中提到的程序崩溃问题。
 */
public class Solution22 {
    public static int findKthTail(jianzhi.three.ListNode root, int n){
        jianzhi.three.ListNode node = root;
        while(node!=null&&n!=0){
            node=node.next;
            n--;
        }
        if(n!=0){return -1;}

        jianzhi.three.ListNode r= root;
        while (r!=null&&node!=null){
            r=r.next;
            node= node.next;
        }
        return r.value;
    }

    public static void main(String[] args) {
        jianzhi.three.ListNode[] ln = new jianzhi.three.ListNode[6];
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        for (int i = 0; i < ln.length; i++) {
            ln[i] = new jianzhi.three.ListNode();
            ln[i].value = i + 1;
            if (i > 0)
            {ln[i - 1].next = ln[i];}
        }
        System.out.println(findKthTail(ln[0], 3));
    }
}
