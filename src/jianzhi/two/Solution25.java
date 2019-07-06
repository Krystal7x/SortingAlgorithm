package jianzhi.two;

/**
 * Created by tt on 2018/9/18.
 */
public class Solution25 {

    public static jianzhi.three.ListNode merge(jianzhi.three.ListNode n1, jianzhi.three.ListNode n2) {
        if(n1 ==null && n2==null){ return null;}
        if(n1 ==null){ return n2;}
        if(n2 ==null){ return n1;}
        jianzhi.three.ListNode node =null;
        if(n1.value<n2.value)
        {
            node=n1;
            node.next=merge(n1.next,n2);
        }else{
            node=n2;
            node.next=merge(n1,n2.next);

        }
        return node;
    }


    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 10 };

        // 定义链表1
        jianzhi.three.ListNode[] ln1 = new jianzhi.three.ListNode[arr1.length];
        for (int i = 0; i < ln1.length; i++) {
            ln1[i] = new jianzhi.three.ListNode();
            ln1[i].value = arr1[i];
            if (i > 0){ln1[i - 1].next = ln1[i];}
        }

        // 定义链表2
        jianzhi.three.ListNode[] ln2 = new jianzhi.three.ListNode[arr2.length];
        for (int i = 0; i < ln1.length; i++) {
            ln2[i] = new jianzhi.three.ListNode();
            ln2[i].value = arr2[i];
            if (i > 0){ln2[i - 1].next = ln2[i];}
        }
        merge(ln1[0], ln2[0]).printOut();
    }
}
